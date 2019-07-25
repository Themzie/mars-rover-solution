package zw.ac.uz.marsrover.model;

public class ConnectionParameters {
    private String hostname;
    private Integer port;

    public ConnectionParameters(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public Integer getPort() {
        return port;
    }
}
