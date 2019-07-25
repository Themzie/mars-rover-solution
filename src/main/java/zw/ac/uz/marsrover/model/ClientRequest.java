package zw.ac.uz.marsrover.model;

public class ClientRequest {
    private String message;
    private String fileLocation;

    public ClientRequest(String message, String fileLocation) {
        this.message = message;
        this.fileLocation = fileLocation;
    }

    public String getMessage() {
        return message;
    }

    public String getFileLocation() {
        return fileLocation;
    }
}
