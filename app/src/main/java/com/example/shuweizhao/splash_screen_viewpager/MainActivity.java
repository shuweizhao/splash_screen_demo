package com.example.shuweizhao.splash_screen_viewpager;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MainActivity extends FragmentActivity {

        ViewPager viewPager=null;
        int numberOfViewPagerChildren = 4;
        int lastIndexOfViewPagerChildren = numberOfViewPagerChildren - 1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            viewPager = (ViewPager) findViewById(R.id.pager);
            viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

            final LayerDrawable background = (LayerDrawable) viewPager.getBackground();

            background.getDrawable(0).setAlpha(0); // this is the lowest drawable
            background.getDrawable(1).setAlpha(0);
            background.getDrawable(2).setAlpha(255); // this is the upper one

            viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
                @Override
                public void transformPage(View view, float position) {

                    int index = (Integer) view.getTag();
                    Drawable currentDrawableInLayerDrawable;
                    currentDrawableInLayerDrawable = background.getDrawable(index);

                    if (position <= -1 || position >= 1) {
                        currentDrawableInLayerDrawable.setAlpha(0);
                    } else if (position == 0) {
                        currentDrawableInLayerDrawable.setAlpha(255);
                    } else {
                        currentDrawableInLayerDrawable.setAlpha((int) (255 - Math.abs(position * 255)));
                    }

                }
            });
        }

        @Override
        public void onBackPressed() {
            if (viewPager.getCurrentItem() == 0) {
                super.onBackPressed();
            }
            else {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        }

    class MyAdapter extends FragmentStatePagerAdapter {

            public MyAdapter(android.support.v4.app.FragmentManager fm) {
                super(fm);
            }

            @Override
            public android.support.v4.app.Fragment getItem(int i) {
                android.support.v4.app.Fragment fragment=null;
                switch (i) {
                    case 0:
                        fragment = new FragmentA();
                        break;
                    case 1:
                        fragment = new FragmentB();
                        break;
                    case 2:
                        fragment = new FragmentC();
                        break;
                    case 3:
                        fragment = new FragmentD();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return numberOfViewPagerChildren;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                if (object instanceof FragmentD) {
                    view.setTag(0);
                }
                if(object instanceof FragmentA){
                    view.setTag(1);
                }
                if(object instanceof FragmentB){
                    view.setTag(2);
                }
                if(object instanceof FragmentC){
                    view.setTag(3);
                }
                return super.isViewFromObject(view, object);
            }
        }

    }
