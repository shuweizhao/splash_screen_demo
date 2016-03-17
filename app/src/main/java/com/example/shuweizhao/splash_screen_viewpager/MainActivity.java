package com.example.shuweizhao.splash_screen_viewpager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends FragmentActivity {


    private MyAdapter mAdapter;
    private ViewPager mPager;
    private CirclePageIndicator mIndicator;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new MyAdapter(getSupportFragmentManager());
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);

    }

    private class MyAdapter extends FragmentPagerAdapter {
            public  final int[] mDrawableResIds = {R.drawable.bg1, R.drawable.bg2,
            R.drawable.bg3, R.drawable.bg4};

            public MyAdapter(android.support.v4.app.FragmentManager fm) {
                super(fm);
            }

            @Override
            public android.support.v4.app.Fragment getItem(int i) {
                return CircleFragment.newInstance(mDrawableResIds[i]);
            }

            @Override
            public int getCount() {
                return mDrawableResIds.length;
            }


        }

    }
