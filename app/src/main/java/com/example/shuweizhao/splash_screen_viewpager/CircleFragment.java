package com.example.shuweizhao.splash_screen_viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by shuweizhao on 3/17/16.
 */public final class CircleFragment extends Fragment {
    private static final String KEY_CONTENT = "TestFragment:Content";
    private int mCurDrawableResId ;

    public static CircleFragment newInstance(int resId) {
        CircleFragment fragment = new CircleFragment();
        fragment.mCurDrawableResId = resId;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mCurDrawableResId = savedInstanceState.getInt(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.circle_fragment, container, false);
        ImageView imageView = (ImageView)rootView.findViewById(R.id.welcome_graph);
        imageView.setImageResource(mCurDrawableResId);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Button button = (Button)rootView.findViewById(R.id.welcome_button);
        if (mCurDrawableResId == R.drawable.bg4) {
            button.setVisibility(View.VISIBLE);
        }
        else {
            button.setVisibility(View.GONE);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), IntermediateActivity.class);
                startActivity(i);
            }
        });
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CONTENT, mCurDrawableResId);
    }
}
