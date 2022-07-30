package kata.review3;

import java.lang.reflect.Executable;
import java.util.Arrays;

public class Test_4_1_8 {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {

        Exception e = new Exception();
        var stack = e.getStackTrace();

//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        if (stack.length >= 3) {
            return stack[2].getClassName() + "#" + stack[2].getMethodName();
        } else {
            return new NullPointerException().getMessage();
        }
    }
}

class Tests2 {
    public static void main(String[] args) {

        System.out.println(Test_4_1_8.getCallerClassAndMethodName());
    }
}