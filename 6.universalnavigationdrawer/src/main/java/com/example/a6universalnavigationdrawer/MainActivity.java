package com.example.a6universalnavigationdrawer;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends NavigationDrawerActivity {

    @BindView(R.id.btn_filter)
    ImageView btnFilter;
    @BindView(R.id.btn_sort)
    ImageView btnSort;
    @BindView(R.id.main_tabs)
    TabLayout mainTabs;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    //@BindView(R.id.fab)
    //FloatingActionButton fab;

    private ViewPager view_Pager;
    private PagerAdapter pagerAdapter;
    private String[] main_ativity_tabs;
    private TabLayout tabLayout;
    private ImageView btn_filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    //@OnClick({R.id.btn_filter, R.id.btn_sort, R.id.fab})
    @OnClick({R.id.btn_filter, R.id.btn_sort})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_filter:
                break;
            case R.id.btn_sort:
                break;
//            case R.id.fab:
//                break;
        }
    }
}
