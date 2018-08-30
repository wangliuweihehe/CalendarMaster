package com.wlw.admin.myapplication.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wlw.admin.myapplication.R;
import com.wlw.admin.myapplication.doalog.BaseBottomSheetFragment;

public class BottomSheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        findViewById(R.id.btn).setOnClickListener(it -> {
            FragmentManager fm = getSupportFragmentManager();
            BaseBottomSheetFragment editNameDialog = new BaseBottomSheetFragment();
            editNameDialog.show(fm, "fragment_bottom_dialog");
        });
    }
}
