package com.fumec.prova02matheuscristoni;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class Fragment02 extends Fragment {
    public static Fragment02 newInstance(String chosen) {
        Bundle args = new Bundle();
        Fragment02 fragment = new Fragment02();
        args.putString("item", chosen);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CustomCanvas customCanvas = new CustomCanvas(getContext(), getArguments().getString("item"));
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            customCanvas.setLayoutParams(new ViewGroup.LayoutParams(getResources().getDisplayMetrics().widthPixels/2, getResources().getDisplayMetrics().heightPixels/2));
        }
        ((FrameLayout)view.findViewById(R.id.frame_fragment02)).addView(customCanvas);
    }
}