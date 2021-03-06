package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        int count = 0;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                System.out.println("Client request # " + (++count));
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    System.out.println("Client:" + str);
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    if (str != null && !str.isEmpty()) {
                        if (str.contains("Hello")) {
                            out.write(("Hey! I am a test server, a young programmer wrote me.\n"
                                    + "To find out which commands I react to write \"Help\"\r\r\r\n").getBytes());
                        } else if (str.contains("Help")) {
                            out.write(("Request command: \n"
                                    + "Hello - Hello\n"
                                    + "Exit - Exit\n"
                                    + "Help - Help\n"
                                    + "These are all commands."
                                    + "An attempt to enter a third-party command can damage your computer.\r\r\r\n").getBytes());
                        } else if (str.contains("ShowExceptionPlz")) {
                            out.write("OK, Take it\r\n\r\n".getBytes());
                            try {
                                throw new Exception("This is your exception");
                            } catch (Exception e) {
                                LOG.error("I'm work, I'm exception", e);
                            }
                        } else if (str.contains("Exit")) {
                            out.write("Connection lost\r\r\r\n".getBytes());
                            out.flush();
                            socket.close();
                            break;
                        } else {
                            out.write("Wrong request. Your computer is damaged. Try - Help\r\n\r\n".getBytes());
                        }
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("Error", e);
        }
    }
}