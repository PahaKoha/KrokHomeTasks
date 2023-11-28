package Task15_Gerasimik_Pavel;

public class EntityAlreadyExistsException extends RuntimeException {
    private final int id;
    private final String entity;

    public EntityAlreadyExistsException(int id, String entity) {
        this.id = id;
        this.entity = entity;
    }

    public int getId() {
        return id;
    }
    public String getEntity() {
        return entity;
    }

    @Override
    public String getMessage() {
        return entity + " с Id: " + id + " уже существует";
    }
}
