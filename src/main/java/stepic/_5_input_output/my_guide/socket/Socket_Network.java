package stepic._5_input_output.my_guide.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Socket_Network {

    public static void socketConnection() throws IOException {
        try (Socket socket = new Socket("localhost", 80)) {

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("GET / HTTP/1.0\r\n\r\n".getBytes());
            outputStream.flush();

            InputStream inputStream = socket.getInputStream();
            int read = inputStream.read();
            while (read >= 0) {
                System.out.println((char) read);
                read = inputStream.read();
            }
        }
    }
}
