package stepic._5_input_output.my_guide.tasks;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetTask {

    /**
     * InputStream последовательно возвращает четыре байта: 48 49 50 51.
     * Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
     */

    public static String method(Reader input) throws IOException {
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[4096];
        for (int i; -1 != (i = input.read(buffer));) {
            builder.append(buffer, 0, i);  // offset - компенсировать / смещение
        }
        return builder.toString();
    }


    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        return method(new InputStreamReader(inputStream, charset));
    }

    public static void main(String[] args) throws IOException {

            InputStream inByte = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
            System.out.println(readAsString(inByte, StandardCharsets.US_ASCII));
    }
}


