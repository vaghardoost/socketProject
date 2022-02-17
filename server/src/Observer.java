public interface Observer {
    void clientMessage(String msg);
    void connectClient();
    void disconnectClient();
}
