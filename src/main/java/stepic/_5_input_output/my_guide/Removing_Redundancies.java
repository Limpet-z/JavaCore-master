package stepic._5_input_output.my_guide;


import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Removing Redundancies From a Path - Удаление избыточности из пути.
 * Многие файловые системы используют "." для обозначения текущего каталога и «..» для обозначения родительского
 * каталога. У вас может возникнуть ситуация, когда Path содержит избыточную информацию о каталоге. Возможно, сервер
 * настроен на сохранение файлов журналов в каталоге " /dir/logs/.", и вы хотите удалить
 * завершающее " /." обозначение из пути.
 */

public class Removing_Redundancies {

    /**
     * The normalize method removes any redundant elements, which includes any "." or "directory/.." occurrences.
     * Both of the preceding examples normalize to /home/joe/foo.
     * <p>
     * Метод normalize удаляет любые избыточные элементы, в том числе любые вхождения "." или "directory/..".
     * Оба предыдущих примера нормализуются к /home/joe/foo.
     * <p>
     * Важно отметить, что normalize при очистке пути не проверяет файловую систему, это чисто синтаксическая операция.
     * Во втором примере, если бы sally была символической ссылкой, удаление sally/.. могло бы привести к тому, Path
     * что больше не находит нужный файл.
     * <p>
     * Чтобы очистить путь, убедившись, что в результате находится правильный файл, вы можете
     * использовать этот toRealPath метод.
     */


    public static void main(String[] args) {

        // Solaris syntax
        Path path = Paths.get("sally/bar");

        // Microsoft Windows syntax
        // Path path = Paths.get("sally\\bar");

    }
}