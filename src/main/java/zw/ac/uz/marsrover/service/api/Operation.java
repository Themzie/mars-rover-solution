package zw.ac.uz.marsrover.service.api;

import zw.ac.uz.marsrover.model.ClientRequest;
import zw.ac.uz.marsrover.model.ConnectionParameters;
import zw.ac.uz.marsrover.model.ServerResponse;

import java.net.Socket;

public interface Operation {
    Socket connect(ConnectionParameters connectionParameters);

    ServerResponse init(Socket controller);

    void send(ClientRequest request, Socket controller);
}
