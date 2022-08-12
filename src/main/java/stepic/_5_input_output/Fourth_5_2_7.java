package stepic._5_input_output;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.System.in;

public class Fourth_5_2_7 {

    public static int sumOfStream1(InputStream inputStream) throws IOException {

        int i;
        int b = 0;

        try {
            while ((i = inputStream.read()) != -1) {
                b += (byte) i;

            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return b;
    }


    public static int sumOfStream(InputStream inputStream) throws IOException {

        int i;
        int b = 0;

        try {

            while (inputStream.available() > 0) {

                i = inputStream.read();
                b += (byte) i;
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return b;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(sumOfStream(in));
    }
}