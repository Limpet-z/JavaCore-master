package stepic._4_exceptions;

public class Fourth_4_2_7 implements AutoCloseable {


    @Override
    public void close() throws Exception {
        System.out.println("Машина закрывается...");
    }


    public static void drive() {
        System.out.println("Машина поехала");
    }

    public static void main(String[] args) {

        try (Fourth_4_2_7 car427 = new Fourth_4_2_7()) {
            car427.drive();
        } catch (Exception ignored) {

        }
    }


}