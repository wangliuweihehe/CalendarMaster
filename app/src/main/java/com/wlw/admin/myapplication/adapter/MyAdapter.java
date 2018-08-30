package com.wlw.admin.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wlw.admin.myapplication.R;
import com.wlw.admin.myapplication.bean.CalenBean;
import com.wlw.admin.myapplication.calendar.CalendarDateController;
import com.wlw.admin.myapplication.calendar.data.CalendarDate;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private List<CalenBean> mData;

    public MyAdapter(List<CalenBean> data) {
        mData = data != null ? data : new ArrayList<CalenBean>();
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        CalenBean bean = mData.get(i);
        myHolder.tv_date.setText(bean.getYear() + "-" + bean.getMonth());
        onBindRecyclerView(myHolder, bean);
        bindWeekData(myHolder);
    }

    private void bindWeekData(MyHolder holder) {
        RecyclerView rv_week = holder.rv_week;
        rv_week.setLayoutManager(new GridLayoutManager(holder.itemView.getContext(), 7));
        String[] week = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
        WeekAdapter adapter = new WeekAdapter(week);
        rv_week.setAdapter(adapter);
    }

    private void onBindRecyclerView(MyHolder myHolder, CalenBean bean) {
        RecyclerView recyclerView = myHolder.recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(myHolder.itemView.getContext(), 7));
        List<CalendarDate> mListDataCalendar = bean.getData();
        DayAdapter mAdapter = new DayAdapter(mListDataCalendar);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnSignListener(new OnSignListener() {
            @Override
            public void onSign(int position) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView tv_date;
        private RecyclerView recyclerView;
        private RecyclerView rv_week;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tv_date);
            recyclerView = itemView.findViewById(R.id.recyclerView);
            rv_week = itemView.findViewById(R.id.rv_week);
        }
    }
}
