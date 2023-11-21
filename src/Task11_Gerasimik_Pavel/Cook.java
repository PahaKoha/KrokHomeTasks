package Task11_Gerasimik_Pavel;

import java.time.DayOfWeek;
import java.util.Objects;
import java.util.Set;

public class Cook {
    private String name;
    private Set<DayOfWeek> workDays;

    public Cook(String name, Set<DayOfWeek> workDays) {
        this.name = name;
        this.workDays = workDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DayOfWeek> getWorkDays() {
        return workDays;
    }

    public void setWorkDays(Set<DayOfWeek> workDays) {
        this.workDays = workDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cook cook = (Cook) o;
        return Objects.equals(name, cook.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, workDays);
    }

    @Override
    public String toString() {
        return "Cook{" +
                "name='" + name + '\'' +
                ", workDays=" + workDays +
                '}';
    }
}
