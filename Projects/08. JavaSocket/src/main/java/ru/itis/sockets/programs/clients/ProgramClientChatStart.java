package ru.itis.sockets.programs.clients;

import ru.itis.sockets.clients.SocketClient;

import java.util.Scanner;

/**
 * 12.02.2019
 * ProgramClientChatStart
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ProgramClientChatStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocketClient client = new SocketClient();
        client.startConnection("127.0.0.1", 6666);
        while (true) {
            String message = scanner.nextLine();
            client.sendMessage(message);
        }
    }
}
