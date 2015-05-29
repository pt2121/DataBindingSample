package com.prt2121.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.prt2121.databinding.BR;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by pt2121 on 5/28/15.
 */
public class MyTime extends BaseObservable {

    private String time;

    private final DateFormat[] format = new DateFormat[]{
            DateFormat.getDateInstance(),
            DateFormat.getDateTimeInstance(),
            DateFormat.getTimeInstance(),
    };

    public MyTime(Date date) {
        time = format[1].format(date);
    }

    public void setTime(Date date) {
        time = format[1].format(date);
        notifyPropertyChanged(BR.time);
    }

    @Bindable
    public String getTime() {
        return time;
    }
}
