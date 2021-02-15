package Lesson6;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends JFrame {
    private final int SERVER_PORT = 8082;
    private final String SERVER_ADDRES = "localhost";
    private Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    private JTextField messageInputField;
    private JTextArea chatArea;

    public Client() throws IOException {
        connect();
        startWindow();
    }

    public void connect() throws IOException {
        socket = new Socket(SERVER_ADDRES, SERVER_PORT);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                while (true) {

                    String msg = dis.readUTF();
                    if (msg.equalsIgnoreCase("/finish")) {
                        System.out.println("Сервер отключилсяю");
                        break;
                    }
                    chatArea.append(msg + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }).start();
    }

    public void send() {
        if (!messageInputField.getText().trim().isEmpty() && messageInputField.getText() != null) {
            try {
                dos.writeUTF(messageInputField.getText());
                chatArea.append(messageInputField.getText());
                messageInputField.setText(" ");
            } catch (IOException e) {

            }
        }
    }

    public void startWindow() {

        setBounds(600, 300, 500, 500);
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton buttonSendMessage = new JButton("Отправить");

        bottomPanel.add(buttonSendMessage, BorderLayout.EAST);
        messageInputField = new JTextField();

        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(messageInputField, BorderLayout.CENTER);
        buttonSendMessage.addActionListener(e -> {
            send();
        });
        messageInputField.addActionListener(e -> {
            send();
        });

        //  addWindowListener(new WindowAdapter() {
        //      @Override
        //      public void windowClosing(WindowEvent e) {
        //          super.windowClosing(e);
        //          try {
        //              out.writeUTF("/end");
        //              closeConnection();
        //          } catch (IOException e1) {
        //              e1.printStackTrace();
        //          }
        //      }
        //  });

        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}


