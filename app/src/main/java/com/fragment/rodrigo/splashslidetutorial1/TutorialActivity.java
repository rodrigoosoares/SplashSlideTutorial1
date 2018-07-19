package com.fragment.rodrigo.splashslidetutorial1;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TutorialActivity extends AppCompatActivity {

    public ViewPager vpTutorialSlide;
    private SliderAdapter sliderAdapter;

    private LinearLayout llTutorialDtos;
    private TextView[] dots;
    private Button btnTutorialSkip;
    private Button btnTutorialFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        vpTutorialSlide = findViewById(R.id.vpTutorialSlide);
        llTutorialDtos = findViewById(R.id.llTutorialDots);
        btnTutorialSkip = findViewById(R.id.btnTutorialSkip);
        btnTutorialFinish = findViewById(R.id.btnTutorialFinish);

        sliderAdapter = new SliderAdapter(this);

        vpTutorialSlide.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        vpTutorialSlide.addOnPageChangeListener(pageChangeListener);
        btnTutorialSkip.setOnClickListener(btnListener);
        btnTutorialFinish.setOnClickListener(btnListener);
    }
    private void addDotsIndicator(int position){
        dots = new TextView[sliderAdapter.getCount()];
        llTutorialDtos.removeAllViews();
        for (int i = 0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getColor(R.color.colorTransparentWhite));
            llTutorialDtos.addView(dots[i]);
        }
        if(dots.length > 0)
            dots[position].setTextColor(getColor(R.color.colorWhite));
        if ((position+1) == sliderAdapter.getCount()) {
            btnTutorialFinish.setEnabled(true);
            btnTutorialFinish.setVisibility(View.VISIBLE);
        }

    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    Button.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnTutorialSkip:
                    finish();
                    break;
                case R.id.btnTutorialFinish:
                    finish();
                    break;
            }
        }
    };

}
