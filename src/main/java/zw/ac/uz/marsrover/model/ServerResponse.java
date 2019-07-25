package zw.ac.uz.marsrover.model;

public class ServerResponse {
    private String sender;
    private String message;

    public ServerResponse(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }
}
