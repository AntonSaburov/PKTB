package edu.javacourse.start;

/**
 * Created by antonsaburov on 09.06.16.
 */
public class Connect {
    String ip;
    int port;
    String login;
    String password;

    Connect() {
    }

    public Connect(String ip, int port, String login, String password) {
        this.ip = ip;
        this.port = port;
        this.login = login;
        this.password = password;
    }
}