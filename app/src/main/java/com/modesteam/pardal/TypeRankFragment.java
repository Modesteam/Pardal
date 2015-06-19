package com.modesteam.pardal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class TypeRankFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    private String fieldName;
    private Object bean;

    private OnFragmentInteractionListener mListener;

    public static TypeRankFragment newInstance(Object object) {
        TypeRankFragment fragment = new TypeRankFragment(object);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public TypeRankFragment(Object object) {
       this.bean = object;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_type_rank, container, false);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.button_totalTickets);
        imageButton.setOnClickListener(this);
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.button_averageExceded);
        imageButton2.setOnClickListener(this);
        ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.button_maximumVelocity);
        imageButton3.setOnClickListener(this);
        return view;
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

    @Override
    public void onClick(View view) {
        String fieldName = null;
        System.out.println("onClinkkkkk");
        switch (view.getId()){
            case R.id.button_totalTickets:
                fieldName = "totalTickets";
                break;
            case R.id.button_averageExceded:
                fieldName = "averageExceded";
                break;
            case R.id.button_maximumVelocity:
                fieldName = "maximumMeasuredVelocity";
                break;
            default:
                fieldName = "";
                break;
        }

        if (fieldName != ""){
            mListener.onFragmentInteraction(0,TopTenListFragment.newInstance(this.bean,fieldName));
        }
    }
}
