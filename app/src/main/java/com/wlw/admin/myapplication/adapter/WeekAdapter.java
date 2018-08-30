package com.wlw.admin.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wlw.admin.myapplication.R;

public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.WeekHolder> {
    String[] week;

    public WeekAdapter(String[] week) {
        this.week = week;
    }

    @NonNull
    @Override
    public WeekHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new WeekHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_week, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WeekHolder weekHolder, int i) {
        weekHolder.tv_day.setText(week[i]);
        Context context = weekHolder.itemView.getContext();
        if (i >= 5)
            weekHolder.tv_day.setTextColor(context.getResources().getColor(R.color.colorWeek));
        else
            weekHolder.tv_day.setTextColor(context.getResources().getColor(R.color.colorGeneral));
    }


    @Override
    public int getItemCount() {
        return week.length;
    }

    class WeekHolder extends RecyclerView.ViewHolder {
        TextView tv_day;

        public WeekHolder(@NonNull View itemView) {
            super(itemView);
            tv_day = itemView.findViewById(R.id.tv_day);
        }
    }
}
