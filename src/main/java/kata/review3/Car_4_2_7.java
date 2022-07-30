package kata.review3;

public class Car_4_2_7 implements AutoCloseable {


    @Override
    public void close() throws Exception {
        System.out.println("Машина закрывается...");
    }


    public static void drive() {
        System.out.println("Машина поехала");
    }

    public static void main(String[] args) {

        try (Car_4_2_7 car427 = new Car_4_2_7()) {
            car427.drive();
        } catch (Exception ignored) {

        }
    }


}