package kata.review3;





/**
 * создать свой класс и наследоваться от Exception/RunTimeException в зависимости от того, какую ошибку нужно
 * обработать.
 * <p>
 * Exception - проверяемые исключения
 * RuntimeException + Error - непроверяемые исключения
 */

public class ExceptionClass_4_1_7 extends Exception {

    public void testExp() throws ExceptionClass_4_1_7 {
        throw new ExceptionClass_4_1_7();
    }
}