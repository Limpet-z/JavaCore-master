package stepic._5_input_output.my_guide.io;

import java.io.IOException;

public class File {

    java.io.File file = new java.io.File("123.exe");


    /**
     * Рекурсивный обход .isDirectory(); для получения всех директорий
     */




    public static void main(String[] args) throws IOException {
        java.io.File file1 = new java.io.File("\\322\\Desktop\\");

        file1.getCanonicalFile();
        file1.isDirectory();

        System.out.println("path: " + file1);
    }

}
