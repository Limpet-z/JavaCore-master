package test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestIvan {
    public static void main(String[] args) throws Throwable {

        // IO - writer
        try (PrintWriter printWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("./out/file1.txt")))) {
            printWriter1.println("Hello");
            printWriter1.println("world!");
        }

        // nio - writer
        try (PrintWriter printWriter2 = new PrintWriter(Files.newBufferedWriter(Path.of("./out/file2.txt")))) {
            printWriter2.println("Hello");
            printWriter2.println("world!");
        }

        // IO - reader 1
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./out/file1.txt"))) {
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
        }

        // nio - reader
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("./out/file1.txt"))) {
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
        }


        // nio - lines метод вернет Stream строк из файла
        Files.lines(Paths.get("./out/file1.txt"))
                .filter(s -> s.length() > 5)
                .forEach(System.out::println);

        List<String> stringList = Files.readAllLines(Paths.get("./out/file1.txt"));
        for (String str: stringList) {
            System.out.println(str);
        }

    }
}
