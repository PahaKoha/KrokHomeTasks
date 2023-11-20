package Task11_Gerasimik_Pavel;

public class IncorrectNameException extends RuntimeException {
    private final String nameOfCook;

    public IncorrectNameException(String nameOfCook) {
        this.nameOfCook = nameOfCook;
    }

    public String getNameOfCook() {
        return this.nameOfCook;
    }

    @Override
    public String getMessage() {
        return "Повара под именем " + nameOfCook + " не существует!";
    }
}
