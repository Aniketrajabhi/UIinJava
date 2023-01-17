package com.example.uidesign.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.uidesign.R;
import com.github.mikephil.charting.charts.BarChart;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StatsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatsFragment newInstance(String param1, String param2) {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        BarChart barChart = (BarChart)view.findViewById(R.id.bar);
        // Inflate the layout for this fragment
        ArrayList<Double> valuesList = new ArrayList<Double>();
        valuesList.add((double)621);
        valuesList.add((double)412);
        valuesList.add((double)144);
        valuesList.add((double)565);
        valuesList.add((double)872);
        valuesList.add((double)225);
        valuesList.add((double)655);

        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < valuesList.size(); i++) {
            BarEntry barEntry = new BarEntry(i+1, valuesList.get(i).floatValue()); //start always from x=1 for the first bar
            entries.add(barEntry);
        }
        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("Mon"); //this label will be mapped to the 1st index of the valuesList
        xAxisLabel.add("Tue");
        xAxisLabel.add("Wed");
        xAxisLabel.add("Thu");
        xAxisLabel.add("Fri");
        xAxisLabel.add("Sat");
        xAxisLabel.add("Sun");
        xAxisLabel.add("");

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setTextColor(Color.YELLOW);
        rightAxis.setTextSize(10);
        rightAxis.setDrawAxisLine(true);
        rightAxis.setAxisLineColor(Color.YELLOW);
        rightAxis.setDrawGridLines(true);
        rightAxis.setGranularity(1f);
        rightAxis.setGranularityEnabled(true);
        rightAxis.setAxisMinimum(0);
        rightAxis.setAxisMaximum(6000f);
        rightAxis.setLabelCount(4, true); //draw y labels (Y-Values) for 4 horizontal grid lines starting from 0 to 6000f (step=2000)
        rightAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);

        //initialize Y-Left-Axis
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setAxisMinimum(0);
        leftAxis.setTextColor(Color.YELLOW);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawGridLines(false);
        leftAxis.setLabelCount(0, true);
        leftAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return "";
            }


        });
        BarDataSet barDataSet = new BarDataSet(entries, "Days");
        barDataSet.setColor(Color.parseColor("#f1c232"));
        barDataSet.setBarBorderWidth(1);
        barDataSet.setValueTextColor(Color.WHITE);
        barDataSet.setGradientColor(Color.parseColor("#e9ae3b"),Color.parseColor("#dbc461"));
        barDataSet.setFormSize(10f);
        barDataSet.setDrawValues(true);
        barDataSet.setValueTextSize(10f);




        //set the BarData to chart
        BarData data = new BarData(barDataSet);
        barChart.setData(data);

//        barChart.setBackgroundColor(Color.parseColor("fff2cc"));
        barChart.setScaleEnabled(true);;
        barChart.getLegend().setEnabled(false);
        barChart.setDrawBarShadow(false);
        barChart.getDescription().setEnabled(false);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(false);
        barChart.invalidate();


        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }
}