package edu.javacourse.start;

/**
 * Created by antonsaburov on 09.06.16.
 */
public class DatabaseDB2 extends Database
{
    @Override
    public void connect(String ip, int port, String login, String password) {
        connectHandler = new Connect();
        connectHandler.ip = ip;
        connectHandler.port = port;
        connectHandler.login = login;
        connectHandler.password = password;
    }

    @Override
    public void disconnect() {
        connectHandler.ip = "";
        // ...
    }
}
