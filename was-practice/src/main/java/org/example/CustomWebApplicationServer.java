package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class CustomWebApplicationServer {
    private final int port;
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplication] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected");

                /*
                * Step1 - 사용자의 요청을 메인 Thread가 처리하도록 한다.
                * Step2 - 사용자 요청이 들어올때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
                * Step3 - Thread Pool을 적용해 안정적인 서비스가 가능하도록 한다.
                * */
                new Thread(new ClientRequestHandler(clientSocket)).start();
            }
        }
    }
}
