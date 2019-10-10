package com.foxy.sunset;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SunsetFragment extends Fragment {

    private View sceneView;
    private View sunView;
    private View skyView;

    public static SunsetFragment newInstance() {
        return new SunsetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sunset, container, false);

        sceneView = view;
        sunView = view.findViewById(R.id.sun);
        skyView = view.findViewById(R.id.sky);

        sceneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        return view;
    }

    private void startAnimation() {
        float sunYStart = sunView.getTop();  // точка начала анимации
        float sunYEnd = skyView.getHeight(); // конец анимации

        ObjectAnimator heightAnimator = ObjectAnimator
                .ofFloat(sunView, "y", sunYStart, sunYEnd)
                .setDuration(3000);
        heightAnimator.setInterpolator(new AccelerateInterpolator()); // ускорение солнца

        heightAnimator.start();
    }
}
