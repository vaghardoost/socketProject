import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class Agent implements Runnable{
    private final Socket socket;
    private final List<Observer> observerList;
    public Agent(Socket socket, List<Observer> observerList){
        this.socket = socket;
        this.observerList = observerList;
        notifyConnect();
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            while (true){
                String msg = in.readUTF();
                if (msg.equals("close")) return;
                notifyMessages(msg);
                out.writeUTF("you send a msg:"+msg);
            }
        } catch (IOException e) {
            notifyDisconnect();
        }
    }

    private void notifyMessages(String msg){
        observerList.forEach(observer -> observer.clientMessage(msg));
    }

    private void notifyConnect(){
        observerList.forEach(Observer::connectClient);
    }

    private void notifyDisconnect(){
        observerList.forEach(Observer::disconnectClient);
    }
}
