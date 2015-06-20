    package com.modesteam.pardal;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.modesteam.pardal.brand.BrandContent;
import com.modesteam.pardal.category.CategoryContent;
import com.modesteam.pardal.city.CityContent;
import com.modesteam.pardal.highwayStretch.HighwayStretchContent;
import com.modesteam.pardal.model.ModelContent;
import com.modesteam.pardal.state.StateContent;
import com.modesteam.pardal.type.TypeContent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Brand;
import models.City;
import models.HighwayStretch;
import models.Model;
import models.State;
import models.Type;


    /**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link RankOrListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RankOrListFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Object bean;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RankOrListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RankOrListFragment newInstance(String param1, String param2) {
        RankOrListFragment fragment = new RankOrListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RankOrListFragment() {
        // Required empty public constructor
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

        List<State> listState = (ArrayList<State>) StateContent.ITEMS;
        List<City> listCity = (ArrayList<City>) CityContent.ITEMS;
        List<HighwayStretch> listHigh = (ArrayList<HighwayStretch>) HighwayStretchContent.ITEMS;
        List<Model> listModel = (ArrayList<Model>) ModelContent.ITEMS;
        List<Type> listType = (ArrayList<Type>) TypeContent.ITEMS;
        List<Brand> listBrand = (ArrayList<Brand>) BrandContent.ITEMS;



        View view = inflater.inflate(R.layout.fragment_rank_or_list, container, false);
        ImageButton bRank = (ImageButton) view.findViewById(R.id.bRank);
        ImageButton bList = (ImageButton) view.findViewById(R.id.bList);
        bRank.setOnClickListener(this);
        bList.setOnClickListener(this);
        RelativeLayout relative = (RelativeLayout) view.findViewById(R.id.rank_or_list);
        Drawable drawable = null;


        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Quango.otf");
        TextView sRanking = (TextView) view.findViewById(R.id.sRanking);
        sRanking.setTypeface(typeface);
        TextView sList = (TextView) view.findViewById(R.id.sList);
        sList.setTypeface(typeface);
        TextView textView = (TextView) view.findViewById(R.id.textViewDesc);
        textView.setTypeface(typeface);
        TextView textView2= (TextView) view.findViewById(R.id.textViewTotal);
        textView2.setTypeface(typeface);

        switch(mParam1) {
            case "1":
                textView.setText("Estados Brasileiros");
                int tamanho1 = listState.size();
                textView2.setText("Total de Estados: "+ Integer.toString(tamanho1));
                drawable = getResources().getDrawable(R.drawable.statebg);
                break;
            case "2":
                textView.setText("Cidades Brasileiras");
                int tamanho2 = listCity.size();
                textView2.setText("Total de Cidades: "+ Integer.toString(tamanho2));
                drawable = getResources().getDrawable(R.drawable.citybg);
                break;
            case "3":
                textView.setText("Rodovias Brasileiras");
                int tamanho3 = listHigh.size();
                textView2.setText("Total de Rodovias: "+ Integer.toString(tamanho3));
                drawable = getResources().getDrawable(R.drawable.highwaybg);
                break;
            case "4":
                textView.setText("Modelos de Veículos");
                int tamanho4 = listModel.size();
                textView2.setText("Total de Modelos: "+ Integer.toString(tamanho4));
                drawable = getResources().getDrawable(R.drawable.modelbg);
                break;
            case "5":
                textView.setText("Tipos de Veículos");
                int tamanho5 = listType.size();
                textView2.setText("Total de Tipos: "+ Integer.toString(tamanho5));
                drawable = getResources().getDrawable(R.drawable.typebg);
                break;
            case "6":
                textView.setText("Marcas de Veículos");
                int tamanho6 = listBrand.size();
                textView2.setText("Total de Marcas: "+ Integer.toString(tamanho6));
                drawable = getResources().getDrawable(R.drawable.brandbg);
                break;
        }
        relative.setBackgroundDrawable(drawable);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
   // public void onButtonPressed(Uri uri) {
     ///   if (mListener != null) {
       //     mListener.onFragmentInteraction(uri);
       // }
    //}

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
            switch(view.getId()){
                case R.id.bRank:
                    switch(mParam1){
                        case "1":
                            bean = new State();
                            break;
                        case "2":
                            bean = new City();
                            break;
                        case "3":
                            bean = new HighwayStretch();
                            break;
                        case "4":
                            bean = new Model();
                            break;
                        case "5":
                            bean = new Type();
                            break;
                        case "6":
                            bean = new Brand();
                            break;

                    }
                    mListener.onFragmentInteraction(0, TypeRankFragment.newInstance(bean, mParam1));
                    break;
                case R.id.bList:
                    switch(mParam1){
                        case "1":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(1).id, StateListFragment.newInstance("1", ""));
                            break;
                        case "2":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(2).id, CityListFragment.newInstance("2", ""));
                            break;
                        case "3":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(3).id, HighwayStretchListFragment.newInstance("3", ""));
                            break;
                        case "4":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(4).id, ModelListFragment.newInstance("4", ""));
                            break;
                        case "5":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(5).id, TypeListFragment.newInstance("5", ""));
                            break;
                        case "6":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(6).id, BrandListFragment.newInstance("6", ""));
                    }
                    break;
            }
        }
}
