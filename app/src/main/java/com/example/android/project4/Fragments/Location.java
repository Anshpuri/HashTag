package com.example.android.project4.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.android.project4.MainActivity;
import com.example.android.project4.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.entries;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Location interface
 * to handle interaction events.
 * Use the {@link Location#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Location extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    PieChart mChart;



    public Location() {
        // Required empty public constructor
    }


    public static Location newInstance(String param1, String param2) {
        Location fragment = new Location();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_location, container, false);
        mChart = (PieChart)v.findViewById(R.id.piechart2);
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleRadius(7);
        mChart.setTransparentCircleRadius(10);

        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(4f,"NEW DELHI"));
        entries.add(new PieEntry(8f, "PUNJAB"));
        entries.add(new PieEntry(6f, "BIHAR"));
        entries.add(new PieEntry(12f, "RAJASTHAN"));
        entries.add(new PieEntry(18f, "MAHARASHTRA"));
        entries.add(new PieEntry(9f, "KARNATAKA"));
        PieDataSet dataSet = new PieDataSet(entries,"Location");

//        ArrayList<String> labels = new ArrayList<>();
//        labels.add("New Delhi");
//        labels.add("Uttarakhand");
//
//        labels.add("Rajasthan");
//        labels.add("Maharashtra");
//        labels.add("Karnataka");
        PieData data = new PieData(dataSet);
        mChart.setData(data);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        return v;
    }
}
