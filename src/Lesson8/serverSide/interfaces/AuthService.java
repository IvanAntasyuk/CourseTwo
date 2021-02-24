package Lesson8.serverSide.interfaces;

public interface AuthService {
    void start();
    void stop();
    String getNickbyLoginandPassword(String login, String password);
}
