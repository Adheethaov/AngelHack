package com.visionreboot.kaipunyam.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.visionreboot.kaipunyam.CalendarMonthNameFormatter;
import com.visionreboot.kaipunyam.CustomViews.CalenderView.CalendarView;
import com.visionreboot.kaipunyam.CustomViews.CalenderView.OnDateSelectedListener;
import com.visionreboot.kaipunyam.CustomViews.CalenderView.OnLoadEventsListener;
import com.visionreboot.kaipunyam.CustomViews.CalenderView.OnMonthChangedListener;
import com.visionreboot.kaipunyam.CustomViews.CalenderView.event.CalendarEvent;
import com.visionreboot.kaipunyam.EventsAdapter;
import com.visionreboot.kaipunyam.MyEvent;
import com.visionreboot.kaipunyam.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by BincyBaby on 29/07/18.
 * Copyright (c) 2018 Padath Infotainment
 */
public class CalenderActivity extends AppCompatActivity implements OnMonthChangedListener,
        OnDateSelectedListener, OnLoadEventsListener {
    private CalendarView mCalendarView;
    private CalendarMonthNameFormatter mFormatter = new CalendarMonthNameFormatter();

    private EventsAdapter mEventsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);


        Toolbar bookmarkedToolBar = findViewById(R.id.toolBarArticle);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        setSupportActionBar(bookmarkedToolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Order Planner");
        }

        mCalendarView = findViewById(R.id.calendarView);

        mEventsAdapter = new EventsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mEventsAdapter);


        mCalendarView.setOnMonthChangedListener(this);
        mCalendarView.setOnLoadEventsListener(this);
        mCalendarView.setOnDateSelectedListener(this);

        Calendar calendar = Calendar.getInstance();

        calendar.set(2018, Calendar.JULY, 1);
        mCalendarView.setMinimumDate(calendar.getTimeInMillis());

        calendar.set(2019, Calendar.OCTOBER, 1);
        mCalendarView.setMaximumDate(calendar.getTimeInMillis());

        FloatingActionButton fab = findViewById(R.id.pennyFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showInputDialog();
            }
        });


    }


    @Override
    public void onMonthChanged(Calendar monthCalendar) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(mFormatter.format(monthCalendar));
        }
    }

    @Override
    public void onDateSelected(Calendar dayCalendar, @Nullable List<CalendarEvent> events) {
        mEventsAdapter.clearList();

        if (events == null) {
            return;
        }

        for (CalendarEvent event : events) {
            if (event instanceof MyEvent) {
                mEventsAdapter.addEvent((MyEvent) event);
            }
        }
    }


    @Override
    public List<? extends CalendarEvent> onLoadEvents(int year, int month) {
        // Fill by random events
        List<MyEvent> events = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);

        int[] daysNumbs = getRandomNumbs(1, calendar.getActualMaximum(Calendar.DAY_OF_MONTH),10); // Events count

        for (int dayNumb : daysNumbs) {
            calendar.set(Calendar.DAY_OF_MONTH, dayNumb);
            MyEvent event = new MyEvent("There will be three dosa's", calendar.getTimeInMillis(), getRandomColor());
            events.add(event);
        }

        return events;
    }


    private int getRandomColor() {
        Resources resources = getResources();
        return resources.getColor(R.color.colorPrimary);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    protected void showInputDialog() {

        LayoutInflater layoutInflater = LayoutInflater.from(CalenderActivity.this);
        View promptView = layoutInflater.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CalenderActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    private int[] getRandomNumbs(int start, int end, int count) {
        int[] numbs = new int[count];

        for (int i = 0; i < numbs.length; i++) {
            int numb = start + (int) (Math.random() * end);
            numbs[i] = numb;
        }

        return numbs;
    }
}
