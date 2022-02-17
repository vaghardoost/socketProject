import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.attach(new Observer() {
            @Override
            public void clientMessage(String msg) {
                System.out.println("a client has new message:"+msg);
            }

            @Override
            public void connectClient() {
                System.out.println("a new client connect to our server");
            }

            @Override
            public void disconnectClient() {
                System.out.println("a client disconnect");
            }
        });
        server.startService();
    }
}
