package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8082;

    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Подключен к серверу: " + socket.getRemoteSocketAddress());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            Thread threadReader = new Thread(() -> {
                try {
                    while (true) {
                        dos.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            threadReader.setDaemon(true);
            threadReader.start();

            while (true) {
                String str = dis.readUTF();
                if (str.equals("/close")) {
                    System.out.println("Потеряно соединение с сервером");
                    dos.writeUTF("/close");
                    break;
                } else {
                    System.out.println("Сервер: " + str);
                }
            }
        } catch (IOException ignored) {

        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {

            }
        }
    }
}



