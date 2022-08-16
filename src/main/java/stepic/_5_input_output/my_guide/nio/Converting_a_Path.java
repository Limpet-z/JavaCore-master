package stepic._5_input_output.my_guide.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Converting_a_Path { // Преобразование пути


    /**
     * Вы можете использовать три метода для преобразования файла Path. Если вам нужно преобразовать путь в строку,
     * которую можно открыть из браузера, вы можете использовать toUri. Например:
     */

    public static void main(String[] args) {

        Path path = Paths.get("/home/logfile");
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
        Path inputPath = Paths.get(args[0]);

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

        Path fullPath = inputPath.toAbsolutePath();

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
            Path fp = path.toRealPath();
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
            // Logic for case when file doesn't exist.
        } catch (IOException x) {
            System.err.format("%s%n", x);
            // Logic for other sort of file error.
        }
    }
}
