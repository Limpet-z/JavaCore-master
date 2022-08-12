package stepic._5_input_output;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal. Массив байт устроен следующим образом.
 * Сначала идет число типа int, записанное при помощи ObjectOutputStream.writeInt(size). Далее подряд записано указанное количество
 * объектов типа Animal, сериализованных при помощи ObjectOutputStream.writeObject(animal).
 * <p>
 * Если вдруг массив байт не является корректным представлением массива экземпляров Animal, то метод должен бросить
 * исключение java.lang. IllegalArgumentException.
 * <p>
 * Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные данные и посмотрите,
 * какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException и выбросить. Если что-то забудете,
 * то проверяющая система подскажет. Главное не глотать никаких исключений, т.е. не оставлять нигде пустой catch.
 */

public class AnimalSerialization {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]
                {new Animal("cat"),
                        new Animal("dog"),
                        new Animal("duck"),
                        new Animal("horse")};

        System.out.println(Arrays.toString(animals));
        byte[] serializedAnimals = serializeAnimalArray(animals);
        Animal[] deserializedAnimals = deserializeAnimalArray(serializedAnimals);
        System.out.println(Arrays.toString(deserializedAnimals));
        System.out.printf("arrays are equals: %s", Arrays.equals(animals, deserializedAnimals));

    }

    public static byte[] serializeAnimalArray(Animal[] animals) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(outputStream)) {
            oos.writeInt(animals.length);
            for (Animal animal : animals) {
                oos.writeObject(animal);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return outputStream.toByteArray();
    }

    public static Animal[] deserializeAnimalArray(byte[] data) { // take solution here || don't change method signature
        Animal[] animals;
        try(ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))){
            int numAnimals = ois.readInt();
            animals = new Animal[numAnimals];
            for (int i = 0; i < numAnimals; i++) {
                animals[i] = (Animal) ois.readObject();
            }
        } catch (RuntimeException | ClassNotFoundException | IOException e) {
            throw new IllegalArgumentException(e);
        }
        return animals;
    }
}

class Animal implements Serializable {
    private final String name;
    public Animal(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}


