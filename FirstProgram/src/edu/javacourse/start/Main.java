package edu.javacourse.start;

/**
 * Created by antonsaburov on 09.06.16.
 */
public class Main
{
    public static void main(String[] args) {
        int t = getInt();
        int a = summa(12, 45);

        String sql = "INSERT INTO SP_TABLE (VAL1, VAL2) VALUES (" + a + "," + t + ")";

        Database ab1 = new DatabaseDB2();
        ab1.connect("Host1", 5432, "login", "password");
        for(int i = 0; i<10; i++) {
            ab1.insertSQLRequest(sql);
        }
        ab1.disconnect();

    }

    static int getInt() {
        return 25+18;
    }

    static int summa(int t1, int t2) {
        int t = t1 + t2;

        return t;
    }
}
