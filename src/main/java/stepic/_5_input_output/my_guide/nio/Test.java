package stepic._5_input_output.my_guide.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

    Path path = Paths.get("C:\\Users\\322\\Desktop\\Tinkoff Task");

    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\322\\Desktop\\Tinkoff Task");
        path.getFileName();
        path.getFileSystem();
        System.out.println(path.getFileSystem());
        System.out.println(path.getFileName());
        System.out.println(path.toAbsolutePath());

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {

            for (var x : directoryStream) {
                System.out.println(x);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}