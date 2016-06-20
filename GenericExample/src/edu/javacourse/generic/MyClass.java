package edu.javacourse.generic;

/**
 * Created by antonsaburov on 20.06.16.
 */
public class MyClass implements Comparable<MyClass>
{
    private String name;

    public MyClass(String name) {
        if(name == null) {
            throw new IllegalArgumentException("NULL argument");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(MyClass o) {
        return this.name.compareTo(o.name);
    }
}
