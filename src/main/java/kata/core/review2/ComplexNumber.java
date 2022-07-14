package kata.core.review2;

/*
*  Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так, чтобы equals() сравнивал экземпляры
*  ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().
*  Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет
*
* ComplexNumber a = new ComplexNumber(1, 1);
  ComplexNumber b = new ComplexNumber(1, 1);
    // a.equals(b) must return true
    // a.hashCode() must be equal to b.hashCode()
    *
    * Поищите в классе java.lang.Double статический метод, который поможет в решении задачи.
    * Если задача никак не решается, можно позвать на помощь среду разработки, которая умеет сама
    *  генерировать equals() и hashCode(). Если вы воспользовались помощью IDE, то разберитесь, что было
    *  сгенерировано и почему оно выглядит именно так. Когда вас на собеседовании попросят на бумажке
    * реализовать equals() и hashCode() для какого-нибудь простого класса, то среда разработки помочь не сможет.
* */

import java.util.Arrays;
import java.util.Objects;

public class ComplexNumber {
    private double re;
    private double im;

    public ComplexNumber() {
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }


    @Override
    public boolean equals(Object o) {

        //1 Сравнение сравнивает текущий экземпляр объекта this с переданным объектом o
        if (this == o) {
            return true;
        }

        //2 Проверка переданного объекта на null и его Тип (если лругой тип - false)
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        //3 Сравнение полей объектов
        ComplexNumber complexNumber = (ComplexNumber) o;
        return re == complexNumber.re && im == complexNumber.im;
    }

    @Override
    public int hashCode() {
        int result = 31;

        long x = Double.doubleToLongBits(re);
        long y = Double.doubleToLongBits(im);

        result = result * 17 + (int)(x ^ (x >>> 32));
        result = result * 17 + (int)(y ^ (y >>> 32));
        return result;
    }

    public static void main(String[] args) {
        ComplexNumber complexNumber1 = new ComplexNumber(1.3, 2.2);
        ComplexNumber complexNumber2 = new ComplexNumber(1.3, 2.2);

        System.out.println(complexNumber1.equals(complexNumber2));
    }
}
