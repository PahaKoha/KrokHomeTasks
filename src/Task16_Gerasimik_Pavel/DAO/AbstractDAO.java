package Task16_Gerasimik_Pavel.DAO;

public abstract class AbstractDAO<T> {
    public abstract T findEntity(int id);

    public abstract T updateEntity(T entity);

    public abstract void deleteEntity(int id);
}
