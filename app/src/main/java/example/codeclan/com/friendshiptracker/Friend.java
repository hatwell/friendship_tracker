package example.codeclan.com.friendshiptracker;

import android.util.Log;


import java.sql.Time;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.jar.Pack200;

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
    private TimeUnit timeUnit;


    private Date today = Calendar.getInstance().getTime();


    public Friend(String firstName, String lastName, int totalDays) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalDays = totalDays;
        this.dateSet = Calendar.getInstance().getTime();
        this.daysRemaining = 0;

    }

    public Friend() {

    }

    public long differenceInDays(Date date1, Date date2, TimeUnit timeUnit){
        long diffInDays = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInDays, TimeUnit.MILLISECONDS);
    }



    //Getters n setters

    public int getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public long getDaysRemaining() {
        return this.getTotalDays() + this.differenceInDays(this.getDateSet(), today, TimeUnit.DAYS);
    }


    public Date getDateSet(){
        return dateSet;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setDateSet(long timestamp){
        this.dateSet = new Date(timestamp);
    }

    //end of getters and setters, now some more interesting stuff


    //Resets number of days left until you see your pal to full amount.

    public void resetDays(){
        this.daysRemaining = totalDays;
    }


}
