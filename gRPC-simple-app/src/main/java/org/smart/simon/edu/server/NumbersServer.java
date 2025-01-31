package org.smart.simon.edu.server;

import lombok.extern.java.Log;


@Log
public class NumbersServer {

    public static void main(String[] args) throws I0Exception, InterruptedException {
        log.info("numbers Server is starting...");
        int port = getServerPort();
        Server server = ServerBuilder.forPort(port)
                .addService(new NumbersServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Received shutdown request");
            server.shutdown();
            log.info("Server stopped");
        }));
        log.info(String.format("Server is waiting for client, port: %d", port));
        server.awaitTermination();
    }
}
