package com.wlw.admin.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.wlw.admin.myapplication.adapter.MyAdapter;
import com.wlw.admin.myapplication.bean.CalenBean;
import com.wlw.admin.myapplication.calendar.CalendarDateController;
import com.wlw.admin.myapplication.calendar.DateUtils;
import com.wlw.admin.myapplication.calendar.data.CalendarDate;
import com.wlw.admin.myapplication.helper.MonthHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PagerSnapHelper pagerSnapHelper;
    private List<CalenBean> mData;
    private int mThisMonthPosition = DateUtils.getYear() * 12 + DateUtils.getMonth() - 1;
    private LinearLayoutManager linearLayoutManager;
    private int index, currentposition;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
        initData();
        myAdapter = new MyAdapter(mData);
        recyclerView.setAdapter(myAdapter);
        recyclerView.addOnScrollListener(new RecyclerViewScrollDetector());
        recyclerView.scrollToPosition(currentposition);
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.addAll(MonthHelper.getInstance().findAllMonths());
        if (mData.size() == 0) {
            CalenBean bean = new CalenBean();
            bean.setYear((mThisMonthPosition) / 12);
            bean.setMonth((mThisMonthPosition) % 12 + 1);
            bean.setData(CalendarDateController.getCalendarDate(bean.getYear(), bean.getMonth()));
            index = 0;
            mData.add(bean);
            MonthHelper.getInstance().saveMonth(bean);
        } else {
            index = mData.size() - 1;
            for (int i = 0; i < mData.size(); i++) {
                CalenBean bean = mData.get(i);
                if (DateUtils.getYear() == bean.getYear() && DateUtils.getMonth() == bean.getMonth()) {
                    currentposition = i;
                    return;
                }
            }
        }
    }

    public void onLoadData() {
        index++;
        CalenBean bean = new CalenBean();
        bean.setYear((index + mThisMonthPosition) / 12);
        bean.setMonth((index + mThisMonthPosition) % 12 + 1);
        bean.setData(CalendarDateController.getCalendarDate(bean.getYear(), bean.getMonth()));
        mData.add(bean);
        myAdapter.notifyDataSetChanged();
        MonthHelper.getInstance().saveMonth(bean);
    }

    class RecyclerViewScrollDetector extends RecyclerView.OnScrollListener {
        private int lastVisibleItem = 0;

        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == myAdapter.getItemCount()) {
                onLoadData();
            }
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
        }
    }
}
