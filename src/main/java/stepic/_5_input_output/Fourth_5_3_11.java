package stepic._5_input_output;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

 * Пример:
 * InputStream последовательно возвращает четыре байта: 48 49 50 51.
 * Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".
 */

public class Fourth_5_3_11 {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        return toString(new InputStreamReader(inputStream, charset));
    }

    public static String toString(final Reader input) throws IOException {
        final StringBuilder sb = new StringBuilder();
        final char[] buffer = new char[4096];
        for (int i; -1 != (i = input.read(buffer));) {
            sb.append(buffer, 0, i);
        }
        return sb.toString();
    }
}

