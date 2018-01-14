package com.example.a6universalnavigationdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondaryFragment extends Fragment {


    public SecondaryFragment() {
        // Required empty public constructor
    }

    public static SecondaryFragment getInstance() {
        return new SecondaryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secondary, container, false);
    }

}
