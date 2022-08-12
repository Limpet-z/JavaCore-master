package stepic._5_input_output;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Напишите метод void print(InputStream inputStream, OutputStream outputStream) который принимает InputStream и
 * OutputStream, считывает все байты из inputStream и записывает в OutputStream только четные.

 * Пример ввода: 3, 10, 4, 5, 7
 * Пример вывода: 10, 4
 */

public class Fourth_5_2_8 {

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {

        try {
            int i;
            while ((i = inputStream.read()) != -1) {
                if (i % 2 == 0) {
                    outputStream.write(i);
                }
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if ((outputStream != null)) {
                outputStream.close();
            }
        }
    }
}