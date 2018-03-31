package com.example.nicolai.diceintentremake.BE;

/**
 * Created by Nicolai on 19-03-2018.
 */
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class BEDiceHistory implements Serializable {

    Date mTime;
    int[] mEyes;



    public BEDiceHistory(Date t, int[] e) {
        mTime = t;
        mEyes = e;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public int[] getmEyes() {
        return mEyes;
    }

    public void setmEyes(int[] mEyes) {
        this.mEyes = mEyes;
    }

    public String getTime() {
        Date date = mTime;   // given date
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date
        //    Integer day = calendar.get(Calendar.DAY_OF_WEEK);
        Integer dayHour = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        Integer minute = calendar.get(Calendar.MINUTE);        // gets hour in 12h format
        Integer second = calendar.get(Calendar.SECOND);        // gets hour in 12h format
        String finalHour = dayHour + ":" + minute + ":" + second + ":   ";
        return finalHour.toString();
    }

}