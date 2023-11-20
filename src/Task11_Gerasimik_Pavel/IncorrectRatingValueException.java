package Task11_Gerasimik_Pavel;

public class IncorrectRatingValueException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Оценка должна быть не ниже 0 и не выше 100!";
    }
}
