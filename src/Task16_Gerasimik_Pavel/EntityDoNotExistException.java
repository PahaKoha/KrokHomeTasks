package Task16_Gerasimik_Pavel;

public class EntityDoNotExistException extends RuntimeException{
    private int id;
    private String entity;

    public EntityDoNotExistException(int id, String entity) {
        this.id = id;
        this.entity = entity;
    }

    @Override
    public String getMessage() {
        return entity + " с id: " + id + " не существует";
    }
}
