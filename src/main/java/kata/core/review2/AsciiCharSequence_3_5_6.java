package kata.core.review2;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Напишите статический класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов
 * (их коды влезают в один байт) в массиве байт. По сравнению с классом String из Java 8, хранящим каждый символ как
 * char, AsciiCharSequence будет занимать в два раза меньше памяти
 *
 * Класс AsciiCharSequence должен:
 *
 * реализовывать интерфейс java.lang.CharSequence;
 * иметь конструктор, принимающий массив байт;
 * определять методы length(), charAt(), subSequence() и toString()
 *
 * Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).
 */

public class AsciiCharSequence_3_5_6 implements CharSequence {
    byte[] array;

    public AsciiCharSequence_3_5_6(byte[] array) {
        this.array = array;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char) array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence_3_5_6(Arrays.copyOfRange(array, start, end));
    }

    @Override
    public String toString() { // конструктор - new String(array)
        return new String(array);
    }
}
