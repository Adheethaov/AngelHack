package com.visionreboot.kaipunyam;

import com.visionreboot.kaipunyam.CustomViews.CalenderView.event.CalendarEvent;

public class MyEvent extends CalendarEvent {

    private String mTitle;

    public MyEvent(String title, long startTimeInMillis, int indicatorColor) {
        super(startTimeInMillis, indicatorColor);
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }
}
