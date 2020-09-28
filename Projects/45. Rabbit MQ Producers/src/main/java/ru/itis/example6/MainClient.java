package ru.itis.example6;

import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        // запускаем клиента
        Client client = new Client();

        Scanner scanner = new Scanner(System.in);
        // в бесконечном цикле
        while (true) {
            // передаем ему имя файла
            String fileName = scanner.nextLine();
            // вызываем метод клиента, который скачивает файл и возвращает его разрмер
            System.out.println(client.downloadFileAndGetSize(fileName));
        }
    }
}
