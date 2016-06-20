package edu.javacourse.collection;

/**
 * Created by antonsaburov on 20.06.16.
 */
public class MyClass implements Comparable
{
    private String name;

    public MyClass() {
    }

    public MyClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof MyClass) {
            MyClass mc = (MyClass) o;
            if(this.getName() == null && mc.getName() != null) {
                return -1;
            }
            if(this.getName() != null && mc.getName() == null) {
                return 1;
            }
            if(this.getName() == null && mc.getName() == null) {
                return 0;
            }

            return this.getName().compareTo(mc.getName());
        }
        throw new IllegalArgumentException("Wrong class:" + o.getClass().getCanonicalName());
    }

    @Override
    public String toString() {
        return "MyClass{" + "name='" + name + '\'' + '}';
    }
}
