package ru.itis.sockets.programs.servers;

import ru.itis.sockets.servers.GreetServer;

public class ProgramServerStart {
    public static void main(String[] args) {
        // создаем экземпляр сервера
        GreetServer server = new GreetServer();
        // размещаем сокет на порту 6666
        server.start(6666);
    }
}
