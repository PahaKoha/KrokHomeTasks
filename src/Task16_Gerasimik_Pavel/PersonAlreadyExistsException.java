package Task16_Gerasimik_Pavel;

public class PersonAlreadyExistsException extends RuntimeException {
    private final int id;

    public PersonAlreadyExistsException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    @Override
    public String getMessage() {
        return  "Person с Id: " + id + " уже существует";
    }
}
