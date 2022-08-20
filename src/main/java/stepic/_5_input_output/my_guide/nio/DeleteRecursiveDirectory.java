package stepic._5_input_output.my_guide.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteRecursiveDirectory {

    public static void main(String[] args) throws IOException {

        String str = "/home/limp/Desktop/Test";
        Path path = Paths.get(str);

        if (Files.exists(path)) {
            // получение содержимого директории
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (var x : directoryStream) {
                    System.out.println(x);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // удаление содержимого и самой директории
            deleteMethod(str);
            System.out.println("Files DELETE2");

        } else {
            if (!Files.exists(path)) {
                System.out.println("Files not found");
            }
        }
    }

    public static void deleteMethod(String str) throws IOException {

        Path directory = Paths.get(str);
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

                if (exc == null) {
                    Files.delete(dir);

                    return FileVisitResult.CONTINUE;
                } else {
                    throw exc;
                }
            }
        });
    }
}