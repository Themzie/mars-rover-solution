package zw.ac.uz.marsrover.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zw.ac.uz.marsrover.model.ClientRequest;
import zw.ac.uz.marsrover.model.ConnectionParameters;
import zw.ac.uz.marsrover.model.ServerResponse;
import zw.ac.uz.marsrover.service.api.Operation;
import zw.ac.uz.marsrover.util.Constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;


@Slf4j
@Service
public class OperationImpl implements Operation {
    public Socket connect(ConnectionParameters connectionParameters) {
        try {
            Socket clientSocket = new Socket(connectionParameters.getHostname(), connectionParameters.getPort());
            return clientSocket;
        } catch (IOException e) {
            log.error(">>>Exception" + e);

        }
        return new Socket();
    }

    public ServerResponse init(Socket controller) {
        try (DataInputStream dataInputStream = new DataInputStream(controller.getInputStream())) {
            String acknowledgementResponse = dataInputStream.readUTF();
            ServerResponse response = new ServerResponse(Constants.SERVER, acknowledgementResponse);
            return response;

        } catch (IOException e) {
            log.error(">>>Exception" + e);
        }
        return null;
    }

    public void send(ClientRequest request, Socket controller) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(controller.getOutputStream())) {
            dataOutputStream.writeUTF(request.getMessage());

            byte[] file = Files.readAllBytes(Paths.get(request.getFileLocation()));
            dataOutputStream.write(file);

        } catch (IOException e) {
            log.error(">>>>>>>Exception" + e);
        }
    }
}
