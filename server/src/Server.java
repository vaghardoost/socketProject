import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final List<Observer> observerList = new ArrayList<>();

    public Server() {

    }

    public void attach(Observer observer){
        System.out.println("new observer!");
        this.observerList.add(observer);
    }

    public void startService(){
        try {
            ServerSocket server = new ServerSocket(9127);
            while(true){
                Socket socket = server.accept();
                new Thread(new Agent(socket,observerList)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
