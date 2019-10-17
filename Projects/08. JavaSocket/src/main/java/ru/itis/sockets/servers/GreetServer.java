package ru.itis.sockets.servers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {
    // используется для обозначения сокет-сервера
    private ServerSocket serverSocket;
    // используется для обозначения сокет-клиента
    private Socket clientSocket;

    private PrintWriter out;
    private BufferedReader in;

    /**
     * Запуск сокет-сервера
     *
     * @param port порт, на котором нужно запустить сокет-сервер
     */
    public void start(int port) {
        try {
            // создаем сокет-сервер
            serverSocket = new ServerSocket(port);
            // accept - ждет, пока к серверу не подключится клиент
            // после того, как клиент будет подключен
            // клиент будет помещен в поле clientSocket
            clientSocket = serverSocket.accept();
            // получаем выходной поток клиента
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            // получили входной поток клиента
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // считали сообщение от клиента
            String greeting = in.readLine();
            // если сообщение было hello server
            System.out.println(greeting);
            if ("hello server".equals(greeting)) {
                // в ответ пишем hello client
                out.println("hello client");
            } else {
                out.println("unrecognised greeting");
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        stop();
    }

    public void stop() {
        try {
            in.close();
            out.close();
            serverSocket.close();
            clientSocket.close();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

}
