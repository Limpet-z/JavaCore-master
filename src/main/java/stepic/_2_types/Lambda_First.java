package stepic._2_types;

import java.math.BigDecimal;

public class Lambda_First {

    public static void main(String[] args) {
        Timer timer = new Timer();
        long time = timer.measureTime(new Runnable() {
            @Override
            public void run() {
                new BigDecimal("1234567").pow(100000);
            }
        });
        System.out.println(time);
    }
}

class Lambda_First_Impl {

    public static void main(String[] args) {
        Timer timer = new Timer();

        // (параметры без типов) -> new BigDecimal("1234567").pow(100000) - лямбда вырожение без {} так как вырожение простое
        // лямбдой можно заменить только реализацию функционального интерфейса, т.е. интерфейса с ед. абстрактным методом


        long time = timer.measureTime(() -> new BigDecimal("1234567").pow(100000));

        // Lambda_First_Impl - имя класса(переменная)
        // :: -
        // blablaMethod - имя метода
        long time2 = timer.measureTime(Lambda_First_Impl::blablaMethod);
        System.out.println(time2);
        System.out.println(time);
        System.out.println(time2);
    }

    private static void blablaMethod() {
        new BigDecimal("1234567").pow(100000);
    }
}

class Timer {
    public long measureTime(Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - startTime;
    }

}
