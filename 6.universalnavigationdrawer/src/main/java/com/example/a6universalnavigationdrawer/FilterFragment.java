package com.example.a6universalnavigationdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilterFragment extends Fragment {

    private FrameLayout container_filter;
    private View locationView, budgetView, genderView, statusView;

    public FilterFragment() {
        // Required empty public constructor
    }

    public static FilterFragment getInstance() {
        return new FilterFragment();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_filter, container, false);
        container_filter = rootView.findViewById(R.id.filter_fragments_container);

        /*rootView.findViewById(R.id.btn_filter_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
                getActivity().getSupportFragmentManager().popBackStackImmediate();
                Toast.makeText(getActivity(),"Close the Filter Fragment",Toast.LENGTH_SHORT);
            }
        });*/

        rootView.findViewById(R.id.btn_filter_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                locationView = LayoutInflater.from(getContext()).inflate(R.layout.view_filter_location, null);
                if (container_filter != null) {
                    container_filter.removeAllViews();
                }
                container_filter.addView(locationView);
            }
        });

        rootView.findViewById(R.id.btn_filter_budget).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                budgetView = LayoutInflater.from(getContext()).inflate(R.layout.view_filter_budget, null);
                if (container_filter != null) {
                    container_filter.removeAllViews();
                }
                container_filter.addView(budgetView);
            }
        });

        rootView.findViewById(R.id.btn_filter_gender).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genderView = LayoutInflater.from(getContext()).inflate(R.layout.view_filter_gender, null);
                if (container_filter != null) {
                    container_filter.removeAllViews();
                }
                container_filter.addView(genderView);
            }
        });

        rootView.findViewById(R.id.btn_filter_status).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusView = LayoutInflater.from(getContext()).inflate(R.layout.view_filter_status, null);
                if (container_filter != null) {
                    container_filter.removeAllViews();
                }
                container_filter.addView(statusView);
            }
        });


        return rootView;
    }

}
