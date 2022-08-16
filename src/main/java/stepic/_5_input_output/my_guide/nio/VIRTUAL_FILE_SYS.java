package stepic._5_input_output.my_guide.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class VIRTUAL_FILE_SYS {

    public static void virtualFileSYS() throws IOException {
        String str = "C:\\Users\\322\\Desktop\\Test";
        Path path = Paths.get(str);


        try (FileSystem fileSystem = FileSystems.newFileSystem(path)) {

            for (Path p : fileSystem.getRootDirectories()) {
                Files.walkFileTree(p, new SimpleFileVisitor<Path>() {

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        System.out.println(file);
                        return FileVisitResult.CONTINUE;
                    }
                });
            }
        }
    }
}