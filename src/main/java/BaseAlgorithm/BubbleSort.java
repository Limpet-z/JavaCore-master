package BaseAlgorithm;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] mas = {11, 3, 14, 16, 7, 19, 32, 32, 435, 345, 4534};

        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(mas));


        for (int i = 0; i < mas.length - 1; i++) {
            boolean EndSort = false;
            while (!EndSort) {
                EndSort = true;


                if (mas[i] > mas[i] + 1) {
                    EndSort = false;

                    int buffer = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buffer;
                }
            }
        }
        System.out.println(Arrays.toString(mas));

        for (int i = 0; i < mas.length - 1; i++) {
            boolean result = false;
            int buff;

            while (!result) {
                result = true;

                if (mas[i] > mas[i + 1]) {

                    buff = mas[i];
                    mas[i + 1] = mas[i];
                    mas[i] = buff;
                }
            }
        }
        System.out.println(Arrays.toString(mas));

        for (int i = 0; i < mas.length - 1; i++) {
            boolean tre = false;
            int bufff;

            while (!tre) {
                tre=true;
                if (mas[i] > mas[i + 1]) {

                    bufff = mas[i];
                    mas[i + 1] = mas[i];
                    mas[i]=bufff;
                }
            }
        }
        System.out.println(Arrays.toString(mas));
    }
}


//          начиная с начала массива просматриваем попарно по 2элемента(первый со вторым,второй с третим,третий с четвертым и т.д.).
//        Если второй элемент в паре меньше первого элемента – перемещаем его на место первого,а первый на место второго.
//        Это мы делаем для всех элементов.
//        После того,как мы дошли до конца массива(сравнили предпоследний и последний элементы и сделали обмен,если нужно),
//        проверяем,был ли хотя бы один обмен.Если да,значит массив не отсортирован и начинаем все сначала.Повторяем
//        такие проходы,пока не будет так,что мы проверили попарно все элементы от начала до конца,а обмена ни одного не было.
//        Таким образом элементы с самыми маленькими значениями потихоньку перемещаются справа налево.
//        То есть они как будто всплывают,как мыльный пузырь.Отсюда и название метода – пузырьком.
