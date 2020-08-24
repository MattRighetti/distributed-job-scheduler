package Server;

public class Message<T> {
    public enum MessageType {
        JOB,
        INFO
    }

    public final int status;
    public final MessageType messageType;
    public final T payload;

    public Message(int status, MessageType messageType, T payload) {
        this.status = status;
        this.messageType = messageType;
        this.payload = payload;
    }
}