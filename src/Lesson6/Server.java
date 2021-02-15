package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Socket socket;

      try(ServerSocket serverSocket = new ServerSocket(8082);){
        System.out.println("Сервер начал свою работу.");
        System.out.println("Ожидаю клиента.");
        socket = serverSocket.accept();
          System.out.println("Клиент подключился.");
          DataInputStream dis = new DataInputStream(socket.getInputStream());
          DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
          while(true){
              String msg = dis.readUTF();
              if (msg.equalsIgnoreCase("/finish")){
                  dos.writeUTF(msg);
                  break;
              }
              dos.writeUTF(" Эхо " + msg);
              dos.flush();
          }


      }catch (IOException e){
      }
    }
}
