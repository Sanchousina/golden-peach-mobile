package com.example.golden_peach_m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class AssetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets);
        LineChart chart = (LineChart) findViewById(R.id.chart);
        LineDataSet dataSet = new LineDataSet(getValues(), "Balance");

        dataSet.setDrawCircles(false);
        dataSet.setColor(getApplicationContext().getResources().getColor(R.color.golden));
        dataSet.setDrawFilled(true);
        dataSet.setFillColor(getApplicationContext().getResources().getColor(R.color.golden));
        dataSet.setLineWidth(4f);
        dataSet.setValueTextSize(14f);
        dataSet.setValueTextColor(getApplicationContext().getResources().getColor(R.color.white));
        //dataSet.setDrawValues(false);
//        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
//        dataSet.setCubicIntensity(0.2f);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();
        chart.setDrawGridBackground(false);
        chart.getLegend().setEnabled(false);

        chart.setTouchEnabled(true);
        chart.setDoubleTapToZoomEnabled(true);
        chart.setScaleEnabled(true);
        chart.setPinchZoom(true);
        chart.setVisibleXRangeMaximum(5);

        final String[] labels = new String[] { "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug", "Sept", "Nov", "Oct", "Dec"};
        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return labels[(int) value];
            }
        };
        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);
        xAxis.setTextSize(14f);
        xAxis.setAxisLineColor(getApplicationContext().getResources().getColor(R.color.perfect_grey));
        xAxis.setTextColor(getApplicationContext().getResources().getColor(R.color.perfect_grey));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setEnabled(false);

        YAxis yAxis = chart.getAxisLeft();
        yAxis.setTextSize(14f);
        yAxis.setAxisLineColor(getApplicationContext().getResources().getColor(R.color.perfect_grey));
        yAxis.setTextColor(getApplicationContext().getResources().getColor(R.color.perfect_grey));
        chart.getAxisRight().setEnabled(false);
    }

    private ArrayList<Entry> getValues(){
        ArrayList<Entry> data = new ArrayList<Entry>();
        data.add(new Entry(0, 60));
        data.add(new Entry(1, 55));
        data.add(new Entry(2, 80));
        data.add(new Entry(3, 60));
        data.add(new Entry(4, 67));
        data.add(new Entry(5, 85));
        data.add(new Entry(6, 70));
        data.add(new Entry(7, 63));
        data.add(new Entry(8, 48));
        data.add(new Entry(9, 55));
        data.add(new Entry(10, 80));
        data.add(new Entry(11, 85));
        return data;
    }
}