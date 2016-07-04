package edu.javacourse.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by antonsaburov on 30.06.16.
 */
public class Main {

    public static void main(String args[]) throws Exception {
        // Переменная для хранения количества считанных байтов
        int c;

        // Открываем сокет для доступа к компьютеру
        // по адресу "internic.net" (порт 43)
        Socket s = new Socket("lib.ru", 80);

        // Открываем поток для записи в сокет (информация будет
        // посылаться от нас на удаленный компьютер
        InputStream in = s.getInputStream();
        // Открываем поток для чтения из сокета (информация будет
        // посылаться нам с удаленного компьютера
        OutputStream out = s.getOutputStream();

        // Готовим строчку с какими-то данными
        String str = "GET /WEBMASTER/rfc2068/section-9.html HTTP/1.1\nhost:lib.ru\n\n";
        // Превращаем их в массив байт для передачи
        // Мы же используем поток, а он рабтает с байтами
        byte buf[] = str.getBytes();
        // Пишем
        out.write(buf);
        // И читаем результат
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
        s.close();
    }



}