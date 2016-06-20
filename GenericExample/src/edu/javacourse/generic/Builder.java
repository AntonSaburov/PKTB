package edu.javacourse.generic;

/**
 * Created by antonsaburov on 20.06.16.
 */
public class Builder<T>
{
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
