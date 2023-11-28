package Task16_Gerasimik_Pavel.Entities;

import java.util.Objects;

public class Pet {
    private int medCardId;
    private String name;
    private int age;

    public Pet(int medCardId, String name, int age) {
        this.medCardId = medCardId;
        this.name = name;
        this.age = age;
    }

    public int getMedCardId() {
        return medCardId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return medCardId == pet.medCardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(medCardId, name, age);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "medCardId=" + medCardId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
