package zw.ac.uz.marsrover.service.impl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import zw.ac.uz.marsrover.model.ClientRequest;
import zw.ac.uz.marsrover.model.ConnectionParameters;
import zw.ac.uz.marsrover.model.ServerResponse;
import zw.ac.uz.marsrover.service.api.Operation;

import java.io.IOException;
import java.net.Socket;

@SpringBootTest
class OperationImplTest {

    @Mock
    private Operation clientOperationsService;

    private ConnectionParameters correctConnectionParameters;
    private ConnectionParameters incorrectConnectionParameters;
    private Socket client;
    private ClientRequest clientRequest;

    @BeforeEach
    void setUp() {
        correctConnectionParameters = new ConnectionParameters("localhost", 77);
        incorrectConnectionParameters = new ConnectionParameters("localhost", 977);
        client = clientOperationsService.connect(correctConnectionParameters);
        clientRequest = new ClientRequest("Controller instustions", "test.txt");
    }

    @Test
    void whenGivenConnectionParameters_thenConnect() {
        client = clientOperationsService.connect(correctConnectionParameters);
        Assertions.assertTrue(client.isConnected());
    }

    @Test
    void whenConnectionFails_ExceptionIsThrown() {
        Assertions.assertThrows(IOException.class, () ->
                clientOperationsService.
                        connect(incorrectConnectionParameters)
        );
    }

    @Test
    void whenClientCorrectlyConfigured_serverShouldSendResponse() {
        ServerResponse serverResponse = clientOperationsService.init(client);
        Assertions.assertEquals(serverResponse.getMessage(), "CONNECTED");
    }


    @Test
    void whenClientIsIncorrectlyConfigured_exceptionIsThrown() {
        Assertions.assertThrows(IOException.class, () ->
                clientOperationsService.
                        init(new Socket())
        );
    }

    @Test
    void whenClientInIncorrectlyConfigured_exceptionIsThrown() {
        Assertions.assertThrows(IOException.class, () ->
                clientOperationsService.
                        send(clientRequest, client)
        );
    }


}