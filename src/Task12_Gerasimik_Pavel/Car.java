package Task12_Gerasimik_Pavel;

import java.util.Objects;

public class Car {
    private final String name;
    private final int doorCount;

    public Car(final String name, final int doorCount) {
        this.name = name;
        this.doorCount = doorCount;
    }

    public String getName() {
        return this.name;
    }

    public int getDoorCount() {
        return this.doorCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return doorCount == car.doorCount && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, doorCount);
    }
}
