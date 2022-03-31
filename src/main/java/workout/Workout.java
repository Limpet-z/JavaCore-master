package workout;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

public class Workout {
    /*
     * CompletableFuture - новый класс для асинхронной работы,
     *  который дает возможность комбинировать шаги обработки, соединяя их в цепочку.
     *  Класс содержит около 50 методов для выполнения, объединения а так же обработки исключений.*/

    /*Для создания CompletableFuture можно воспользоваться методами supplyAsync()*/
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");

    /*где future исполнится в ForkJoinPool.commonPool(), т.к. мы не указывали ему Executor.
    Если мы хотим указать где будет исполняться future то передаем Executor вторым параметром.*/

    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hi", Executors.newCachedThreadPool());

    /* Способ - 2*/

    CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println("Hi"));
    CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> System.out.println("Hi"), Executors.newCachedThreadPool());

        /*Разница в том, что supplyAsync() принимает Supplier, а runAsync -> Runnable. Проще говоря, с помощью supplyAsync()
                                                                            можно вернуть результат, с runAsync() - нельзя.*/

    /*--------------------------------------------------------------------------------------------------------------------------------*/
    /* ПОЛУЧЕНИЕ РЕЗУЛЬТАТА */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);         // имитируем долгое выполнение
            } catch (InterruptedException ignored) {
            }
            return "Hi";
        });
        System.out.println(future4.get()); //output Hi

        /*---------------------------------------------------------------------------------------------------------------------------------*/
        /*Добавление callback*/
        /*Более приемлемым способом обработать результат работы CompletableFuture есть callback. Если после выполнения задачи
                                                                    мы хотим вывести ее на экран, это будет выглядеть так*/
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> "Hi");
        future5.thenAccept(System.out::println);
        future5.get();
    }
}



















