/*
 * Класс для демонстрации рефлексии
 */
package edu.javacourse.reflection;

public class SimpleClass
{
    private String first;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String simple() {
        return "Method1";
    }

    public String concat(String s1, String s2) {
        return s1 + s2;
    }

    public String concat(String s1, Integer s2) {
        return s1 + s2;
    }

}
