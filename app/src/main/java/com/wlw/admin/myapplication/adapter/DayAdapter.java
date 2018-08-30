package com.wlw.admin.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wlw.admin.myapplication.R;
import com.wlw.admin.myapplication.calendar.DateUtils;
import com.wlw.admin.myapplication.calendar.data.CalendarDate;

import java.util.ArrayList;
import java.util.List;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DayHolder> {
    private List<CalendarDate> calendarDates;
    private OnSignListener onSignListener;

    public DayAdapter(List<CalendarDate> calendarDates) {
        this.calendarDates = calendarDates != null ? calendarDates : new ArrayList<CalendarDate>();
    }

    @NonNull
    @Override
    public DayHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DayHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_day, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final DayHolder dayHolder, final int i) {
        Context context = dayHolder.itemView.getContext();
        final CalendarDate calendarDate = calendarDates.get(i);
        if (calendarDate.isInThisMonth()) {
            if (calendarDate.isSelect())
                dayHolder.iv_signed.setVisibility(View.VISIBLE);
            else {
                dayHolder.iv_signed.setVisibility(View.INVISIBLE);
            }
            dayHolder.tv_day.setText(String.valueOf(calendarDate.getSolar().getSolarDay()));
            if (calendarDate.getSolar().getSolarDay() == DateUtils.getDay() && calendarDate.getSolar().getSolarMonth() == DateUtils.getMonth() && calendarDate.getSolar().getSolarYear() == DateUtils.getYear()) {
                dayHolder.itemView.setOnClickListener(it -> {
                    onSignListener.onSign(i);
                    if (!calendarDate.isSelect()) {
                        calendarDate.setSelect(true);
                        dayHolder.iv_signed.setVisibility(View.VISIBLE);
                    }
                });
                dayHolder.tv_day.setTextColor(context.getResources().getColor(R.color.colorAccent));
            } else

            {
                dayHolder.tv_day.setTextColor(context.getResources().getColor(R.color.colorGeneral));
            }
        } else {
            dayHolder.tv_day.setText("");
            dayHolder.iv_signed.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return calendarDates.size();
    }

    public void setOnSignListener(OnSignListener onSignListener) {
        this.onSignListener = onSignListener;
    }

    class DayHolder extends RecyclerView.ViewHolder {
        TextView tv_day;
        ImageView iv_signed;

        public DayHolder(@NonNull View itemView) {
            super(itemView);
            tv_day = itemView.findViewById(R.id.tv_day);
            iv_signed = itemView.findViewById(R.id.iv_signed);
        }
    }
}
