package stepic._4_exceptions;





/**
 * создать свой класс и наследоваться от Exception/RunTimeException в зависимости от того, какую ошибку нужно
 * обработать.
 * <p>
 * Exception - проверяемые исключения
 * RuntimeException + Error - непроверяемые исключения
 */

public class Fourth_4_1_7 extends Exception {

    public void testExp() throws Fourth_4_1_7 {
        throw new Fourth_4_1_7();
    }
}