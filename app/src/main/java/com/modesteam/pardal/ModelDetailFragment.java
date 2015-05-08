package com.modesteam.pardal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.GenericAlertDialogException;
import models.Model;
import models.Tickets;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link //ModelDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ModelDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ModelDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static Model modelDetail;
    private static final String IDModel = "idModel";
    private int idModel;
    // TODO: Rename and change types of parameters


    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static ModelDetailFragment newInstance(Model model) {
        ModelDetailFragment fragment = new ModelDetailFragment();
        Bundle args = new Bundle();
        modelDetail = model;
        args.putInt(IDModel, model.getId());
        fragment.setArguments(args);
        return fragment;
    }

    public ModelDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idModel = getArguments().getInt(IDModel);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_model_detail, container, false);
        createInfo(rootView);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        //if (mListener != null) {
          //  mListener.onFragmentInteraction(uri);
        //}
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
    public void createInfo(View view){
        int numeberTotalTickets=0;
        double topSpeed =0.0;
        double averageVelocity = 0.0;
        ArrayList<Tickets> tickets = null;
        try {

            tickets = modelDetail.getTickets();
            for(Tickets ticket: tickets){
                numeberTotalTickets = numeberTotalTickets + ticket.getTotalTickets();
                if(topSpeed < ticket.getMaximumMeasuredVelocity()){
                    topSpeed = ticket.getMaximumMeasuredVelocity();
                }
                averageVelocity = averageVelocity + ticket.getAverageExceded();
            }
            averageVelocity = averageVelocity/tickets.size();
        }catch(ClassNotFoundException e){
            GenericAlertDialogException genericAlertDialogException = new GenericAlertDialogException();
            genericAlertDialogException.criarAviso(this.getActivity());
        }catch(SQLException e){
            GenericAlertDialogException genericAlertDialogException = new GenericAlertDialogException();
            genericAlertDialogException.criarAviso(this.getActivity());
        }catch (NullPointerException e){
            GenericAlertDialogException genericAlertDialogException = new GenericAlertDialogException();
            genericAlertDialogException.criarAviso(this.getActivity());
        }
        TextView nameModel = (TextView) view.findViewById(R.id.textViewName);
        nameModel.setText(modelDetail.getName());
        TextView totalTicketsLabel = (TextView) view.findViewById(R.id.textViewTickets);
        totalTicketsLabel.setText( Integer.toString(numeberTotalTickets));
        TextView topSpeedLabel = (TextView) view.findViewById(R.id.textViewTopSpeed);
        topSpeedLabel.setText(Double.toString(topSpeed));
        TextView averageVelocityLabel = (TextView) view.findViewById(R.id.textViewAverangeVelocity);
        averageVelocityLabel.setText(String.format("%.2fKM/h", averageVelocity));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
   // public interface OnFragmentInteractionListener {
   // TODO: Update argument type and name
   //     public void onFragmentInteraction(Uri uri);
   // }

}
