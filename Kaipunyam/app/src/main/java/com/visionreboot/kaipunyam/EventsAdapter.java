package com.visionreboot.kaipunyam;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter {

    private List<MyEvent> mEventsList;

    private TimeFormatter mTimeFormatter = new TimeFormatter();

    public EventsAdapter() {
        mEventsList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        return new EventHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyEvent event = mEventsList.get(position);

        ((EventHolder) holder).tvText.setText(event.getTitle());
        ((EventHolder) holder).tvTime.setText(mTimeFormatter.format(event.getTimeInMillis()));
    }

    @Override
    public int getItemCount() {
        return mEventsList.size();
    }

    public void addEvents(List<MyEvent> events) {
        for (int i = 0; i < events.size(); i++) {
            mEventsList.add(events.get(i));
            notifyItemInserted(i);
        }
    }

    public void addEvent(MyEvent event) {
        mEventsList.add(event);
        notifyItemInserted(mEventsList.size());
    }

    public void clearList() {
        mEventsList.clear();
        notifyDataSetChanged();
    }

    class EventHolder extends RecyclerView.ViewHolder {

        TextView tvText, tvTime;
        CardView cardView;

        EventHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            tvText = itemView.findViewById(R.id.tvText);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }
}
