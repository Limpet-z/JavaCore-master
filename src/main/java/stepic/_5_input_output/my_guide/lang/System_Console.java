package stepic._5_input_output.my_guide.lang;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

public class System_Console {

    public static void main(String[] args) throws IOException {
        Console console = System.console();


        StringBuilder s = new StringBuilder();
        int i = System.in.read();
        while (System.in.available() > 0) {
            s.append((char) i);
            i = System.in.read();
        }

        String[] strings = s.toString().split(" ");

        System.out.println(Arrays.toString(strings));
    }
}
