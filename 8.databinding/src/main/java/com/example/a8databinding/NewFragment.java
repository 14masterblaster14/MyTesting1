package com.example.a8databinding;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.a8databinding.databinding.FragmentNewBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends Fragment {


    public NewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentNewBinding fragmentNewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new, container, false);
        FrameLayout frameLayout = fragmentNewBinding.frameLayout;
        fragmentNewBinding.textView.setText("Hello");
        return fragmentNewBinding.getRoot();
        //return inflater.inflate(R.layout.fragment_new, container, false);
    }

}
