public class Cat {
    private String name;
    private int age;
    private String color;
    private double weight;

    // Конструктор по умолчанию (обязателен для POJO)
    public Cat() {
    }

    // Конструктор с параметрами (опционально)
    public Cat(String name, int age, String color, double weight) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    // Геттеры и сеттеры для всех полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Переопределяем toString для удобного вывода (опционально)
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}