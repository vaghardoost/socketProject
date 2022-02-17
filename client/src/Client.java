import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private final List<Observer> observerList = new ArrayList<>();

    {
        try {
            socket = new Socket("localhost",9127);
        } catch (IOException e) {
            notifyDisconnect();
        }
    }

    public Client() {

    }

    public void connect(){
        try{
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            notifyConnect();
            while (true) {
                System.out.print("send a message to server:");
                String answer = new Scanner(System.in).nextLine();
                if (answer.equals("close")) {
                    in.close();
                    out.close();
                    socket.close();
                    notifyDisconnect();
                    return;
                }
                out.writeUTF(answer);
                out.flush();
                String serverMsg = in.readUTF();
                notifyServerMessages(serverMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
            notifyDisconnect();
        }
    }

    public void attach(Observer observer){
        observerList.add(observer);
    }

    private void notifyServerMessages(String msg){
        observerList.forEach(observer -> {
            observer.serverMessage(msg);
        });
    }

    private void notifyDisconnect(){
        observerList.forEach(Observer::disconnect);
    }

    private void notifyConnect(){
        observerList.forEach(Observer::connect);
    }

}
