package edu.javacourse.sales.entity;


import java.util.Date;

/**
 * Created by antonsaburov on 06.06.16.
 */
public class SalesRequest
{
    private String firstName;
    private String lastName;
    private Date from;
    private Date to;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
