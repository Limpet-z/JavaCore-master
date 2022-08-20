package stepic._5_input_output.my_guide.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuffReader {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an number:");
        int a = Integer.parseInt(bufferReader.readLine());
        System.out.printf("You entered: " + a);
    }
}
