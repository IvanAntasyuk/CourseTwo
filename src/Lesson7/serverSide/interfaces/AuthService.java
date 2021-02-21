package Lesson7.serverSide.interfaces;

public interface AuthService {
    void start();
    void stop();
    String getNickbyLoginandPassword(String login, String password);
}
