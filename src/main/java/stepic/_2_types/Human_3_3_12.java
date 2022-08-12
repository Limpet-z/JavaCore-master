package stepic._2_types;

public class Human_3_3_12 {
    

    private int age;
    private String name;
    private String secondName;
    private String favoriteSport;

    public Human_3_3_12() {}

    public Human_3_3_12(int age, String name, String secondName, String favoriteSport) {
        this.age = age;
        this.name = name;
        this.secondName = secondName;
        this.favoriteSport = favoriteSport;
    }

    public Human_3_3_12(int age, String name, String secondName) {
        this.age = age;
        this.name = name;
        this.secondName = secondName;
    }

    public static void main(String[] args) {
        Human_3_3_12 human_1 = new Human_3_3_12();
        Human_3_3_12 human_2 = new Human_3_3_12(1, "Jack", "White", "Sport");
        Human_3_3_12 human_3 = new Human_3_3_12(1, "Jack", "White");

    }
}
