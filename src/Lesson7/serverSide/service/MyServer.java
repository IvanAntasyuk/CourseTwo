package Lesson7.serverSide.service;

import Lesson7.serverSide.interfaces.AuthService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    private final int PORT = 8081;
    private List<ClientHandler> clients;
    private AuthService authService;

    public AuthService getAuthService() {
        return this.authService;
    }

    public MyServer() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            authService = new BaseAuthService();
            authService.start();
            clients = new ArrayList<>();
            while (true) {
                System.out.println("Севрвер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this,socket);
            }

        } catch (IOException e) {
            System.out.println("Сервер рухнул");
        }finally {
            if (authService!=null){
                authService.stop();
            }
        }
    }
    public synchronized void broadcastMessage(String message){
        for (ClientHandler c : clients){
            c.sendMessage(message);
        }
    }
    public synchronized void subscribe(ClientHandler client){
        clients.add(client);
    }
    public synchronized void unsubscribe(ClientHandler client){
        clients.remove(client);
    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler c : clients){
            if (c.getName().equals(nick)){
                return true;
            }
        }
        return false;
    }
}
