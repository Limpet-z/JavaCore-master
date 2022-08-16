package stepic._5_input_output.my_guide.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class Path {

    public static void main(String[] args) {

        java.nio.file.Path path = Paths.get("/home/logfile");
        // Result is file:///home/logfile
        System.out.format("%s%n", path.toUri());
        File file;
        Integer io = 0;
        /**
         * Метод toAbsolutePath преобразует путь в абсолютный путь. Если переданный путь уже является абсолютным,
         * он возвращает тот же Path объект. Этот toAbsolutePath метод может быть очень полезен при обработке вводимых
         * пользователем имен файлов. Например:
         */
        if (args.length < 1) {
            System.out.println("usage: FileTest file");
            System.exit(-1);
        }
        // Converts the input string to a Path object.
        java.nio.file.Path inputPath = Paths.get(args[0]);
        // Converts the input Path
        // to an absolute path.
        // Generally, this means prepending
        // the current working
        // directory.  If this example
        // were called like this:
        //     java FileTest foo
        // the getRoot and getParent methods
        // would return null
        // on the original "inputPath"
        // instance.  Invoking getRoot and
        // getParent on the "fullPath"
        // instance returns expected values.

        java.nio.file.Path fullPath = inputPath.toAbsolutePath();

        /**
         * Метод toAbsolutePath преобразует пользовательский ввод и возвращает значение Path, возвращающее полезные
         * значения при запросе. Для работы этого метода файл необязательно должен существовать.


         * Метод toRealPath возвращает реальный путь к существующему файлу. Этот метод выполняет несколько операций в одной:
         *  1) Если true передается этому методу и файловая система поддерживает символические ссылки, этот метод разрешает
         *      любые символические ссылки в пути.
         *  2) Если Path является относительным, он возвращает абсолютный путь.
         *  3) Если Path содержит какие-либо избыточные элементы, он возвращает путь с удаленными этими элементами.
         * Этот метод создает исключение, если файл не существует или недоступен. Вы можете поймать исключение, если
         * хотите обработать любой из этих случаев. Например:
         */

        try {
            java.nio.file.Path fp = path.toRealPath();
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
            // Logic for case when file doesn't exist.
        } catch (IOException x) {
            System.err.format("%s%n", x);
            // Logic for other sort of file error.
        }

        // None of these methods requires that the file corresponding
        // to the Path exists.
        // Microsoft Windows syntax

        java.nio.file.Path path1 = Paths.get("C:\\home\\joe\\foo");

        // Solaris (UNIX) syntax
        // Path path = Paths.get("/home/joe/foo");

        System.out.format("toString: %s%n", path1.toString());
        System.out.format("getFileName: %s%n", path1.getFileName());
        System.out.format("getName(0): %s%n", path1.getName(0));
        System.out.format("getNameCount: %d%n", path1.getNameCount());
        System.out.format("sub-path(0,2): %s%n", path1.subpath(0, 2));
        System.out.format("getParent: %s%n", path1.getParent());
        System.out.format("getRoot: %s%n", path1.getRoot());

    }
}
