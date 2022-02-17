public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.attach(new Observer() {
            @Override
            public void serverMessage(String msg) {
                System.out.println("server say:"+msg);
            }

            @Override
            public void connect() {
                System.out.println("connect to server");
            }

            @Override
            public void disconnect() {
                System.out.println("disconnected");
            }
        });
        client.connect();
    }
}
