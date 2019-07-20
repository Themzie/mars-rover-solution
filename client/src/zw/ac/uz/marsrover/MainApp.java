package zw.ac.uz.marsrover;


import zw.ac.uz.marsrover.model.ClientRequest;
import zw.ac.uz.marsrover.model.ConnectionParameters;
import zw.ac.uz.marsrover.model.ServerResponse;
import zw.ac.uz.marsrover.services.Operation;
import zw.ac.uz.marsrover.util.Constants;

import java.net.Socket;

public class MainApp {

    public static void main(String args[]) {
        Socket clientSocket;
        ServerResponse serverResponse;

        // 1. Connection
        Operation client = new Operation();
        clientSocket = client.connect(new ConnectionParameters(Constants.HOSTNAME, Constants.SERVER_PORT));
        if (clientSocket.isConnected()) {
            System.out.println(">> Server connection SuccessFul");
        }

        // 2. Initialisation
        serverResponse = client.init(clientSocket);
        System.out.println(serverResponse.getMessage());

        // 3. Send Instructions
        client.send(new ClientRequest("", Constants.CONTROLLER_INSTRUCTIONS_FILE), clientSocket);
    }


}
