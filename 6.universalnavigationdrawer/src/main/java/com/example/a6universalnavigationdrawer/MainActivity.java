package com.example.a6universalnavigationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class MainActivity extends NavigationDrawerActivity {
    @Nullable
    @BindView(R.id.btn_filter)
    ImageView btnFilter;
    @Nullable
    @BindView(R.id.btn_sort)
    ImageView btnSort;
    @Nullable
    @BindView(R.id.main_tabs)
    TabLayout tabLayout;
    @Nullable
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @Nullable
    @BindView(R.id.fab)
    FloatingActionButton fab;
    //private ImageView btnFilter, btnSort;
    private PagerAdapter pagerAdapter;
    private String[] main_activity_tabs;
    //private TabLayout tabLayout;
    //private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

/*
        btnFilter = (ImageView) findViewById(R.id.btn_filter);
        btnSort = (ImageView) findViewById(R.id.btn_sort);
        tabLayout = (TabLayout) findViewById(R.id.main_tabs);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFilterLayout();
            }
        });   */

        initViewPager();
    }

    private void initViewPager() {

        main_activity_tabs = getResources().getStringArray(R.array.main_activity_tabs);
        for (String tabs : main_activity_tabs) {
            tabLayout.addTab(tabLayout.newTab().setText(tabs), true);
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    private void loadFilterLayout() {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, 0, 0, R.anim.slide_out_right)
                .add(R.id.container_navigation_activity, new FilterFragment())
                .addToBackStack(FilterFragment.class.getSimpleName())
                .commit();

    }

    @Optional
    @OnClick({R.id.btn_filter, R.id.btn_sort, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_filter:
                loadFilterLayout();
                break;
            case R.id.btn_sort:
                break;
            case R.id.fab:
                break;
        }
    }
}
