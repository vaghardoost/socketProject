public interface Observer {
    void serverMessage(String msg);
    void connect();
    void disconnect();
}
