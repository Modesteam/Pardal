package com.modesteam.pardal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link CompareFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompareFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_AVERAGE_EXCEDED1 = "averageExceded1";
    private static final String ARG_AVERAGE_EXCEDED2 = "averageExceded2";
    private static final String ARG_TOTAL_TICKETS1 = "totalTickets1";
    private static final String ARG_TOTAL_TICKETS2 = "totalTickets2";
    private static final String ARG_MAXIMUM_MEASURE_VELOCITY1 = "maximumMeasuredVelocity1";
    private static final String ARG_MAXIMUM_MEASURE_VELOCITY2 = "maximumMeasuredVelocity2";
    private static final String ARG_NAME_ITEM1 = "nameItem1";
    private static final String ARG_NAME_ITEM2 = "nameItem2";

    // TODO: Rename and change types of parameters
    private ComparableCategory mParam1;
    private ComparableCategory mParam2;
    private String mParam3;
    private Double averageExceded1;
    private Double averageExceded2;
    private  Double maximumMeasuredVelocity1;
    private Double maximumMeasuredVelocity2;
    private int totalTickets1;
    private int totalTickets2;
    private String nameItem1;
    private String nameItem2;

    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static CompareFragment newInstance(ComparableCategory param1, ComparableCategory param2 ,String param3) {
        CompareFragment fragment = new CompareFragment();
        Bundle args = new Bundle();

        args.putDouble(ARG_AVERAGE_EXCEDED1, param1.getAverageExceded());
        args.putDouble(ARG_AVERAGE_EXCEDED2, param2.getAverageExceded());
        args.putInt(ARG_TOTAL_TICKETS1, param1.getTotalTickets());
        args.putInt(ARG_TOTAL_TICKETS2, param2.getTotalTickets());
        args.putDouble(ARG_MAXIMUM_MEASURE_VELOCITY1, param1.getMaximumMeasuredVelocity());
        args.putDouble(ARG_MAXIMUM_MEASURE_VELOCITY2, param2.getMaximumMeasuredVelocity());
        args.putString(ARG_NAME_ITEM1, param1.toString());
        args.putString(ARG_NAME_ITEM2, param2.toString());

        fragment.setArguments(args);
        return fragment;
    }

    public CompareFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            averageExceded1 = getArguments().getDouble(ARG_AVERAGE_EXCEDED1);
            averageExceded2 = getArguments().getDouble(ARG_AVERAGE_EXCEDED2);
            maximumMeasuredVelocity1 = getArguments().getDouble(ARG_MAXIMUM_MEASURE_VELOCITY1);
            maximumMeasuredVelocity2 = getArguments().getDouble(ARG_MAXIMUM_MEASURE_VELOCITY2);
            totalTickets1 = getArguments().getInt(ARG_TOTAL_TICKETS1);
            totalTickets2 = getArguments().getInt(ARG_TOTAL_TICKETS2);
            nameItem1 = getArguments().getString(ARG_NAME_ITEM1);
            nameItem2 = getArguments().getString(ARG_NAME_ITEM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_brand_detail, container, false);






        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
