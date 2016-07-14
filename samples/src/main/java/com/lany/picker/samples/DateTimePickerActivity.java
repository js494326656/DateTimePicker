package com.lany.picker.samples;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.lany.picker.datetimepicker.DateTimePicker;
import com.lany.picker.ymdhpicker.YmdhPicker;

public class DateTimePickerActivity extends AppCompatActivity {
    private TextView showText;

    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datetime_picker);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        showText = (TextView) findViewById(R.id.lany_picker_show_text);

        DateTimePicker ymdhPicker = (DateTimePicker) findViewById(R.id.ymdhPicker);
        ymdhPicker.setSelectionDivider(new ColorDrawable(0xff000000));
        ymdhPicker.setSelectionDividerHeight(2);
        ymdhPicker.setOnDateChangedListener(new DateTimePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DateTimePicker view, int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minute) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                mHour = hourOfDay;
                mMinute = minute;
                updateDisplay();
            }

        });
    }

    private void updateDisplay() {
        showText.setText(new StringBuilder()
                .append(mYear).append("年")
                .append(mMonth).append("月")
                .append(mDay).append("日")
                .append(mHour).append("时")
                .append(mMinute).append("分"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
