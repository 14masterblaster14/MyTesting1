package com.example.a6universalnavigationdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimaryFragment extends Fragment {


    public PrimaryFragment() {
        // Required empty public constructor
    }

    public static PrimaryFragment getInstance() {
        return new PrimaryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primary, container, false);
    }

}
