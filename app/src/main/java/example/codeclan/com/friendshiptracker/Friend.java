package example.codeclan.com.friendshiptracker;

import java.util.Date;

/**
 * Created by user on 20/04/2017.
 */

public class Friend {
    private int id;
    private String firstName;
    private String lastName;
    private int totalDays;
    private int daysRemaining;
    private Date dateSet;

    public Friend(String firstName, String lastName, int totalDays) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalDays = totalDays;
        this.daysRemaining = totalDays;
        this.dateSet =

    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public int getDaysRemaining() {
        return daysRemaining;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String LastName){
        this.lastName = lastName;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }
}
