package com.fragment.rodrigo.splashslidetutorial1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    //Slides
    private int[] slide_icon = {
            R.drawable.eat_icon,
            R.drawable.code_icon,
            R.drawable.sleep_icon
    };
    private int[] slide_header = {
            R.string.header_slide_tutorial_1,
            R.string.header_slide_tutorial_2,
            R.string.header_slide_tutorial_3,
    };
    private int[] slide_content = {
            R.string.content_slide_tutorial_1,
            R.string.content_slide_tutorial_2,
            R.string.content_slide_tutorial_3
    };

    @Override
    public int getCount() {
        return slide_header.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.tutorial_slide_layout,container,false);
        //Componentes do layout
        ImageView ivTutorialImageIcon = view.findViewById(R.id.ivTutorialImageIcon);
        TextView tvTutorialHeader = view.findViewById(R.id.tvTutorialHeader);
        TextView tvTutorialContent = view.findViewById(R.id.tvTutorialContent);
        //Set dos arrays
        ivTutorialImageIcon.setImageResource(slide_icon[position]);
        tvTutorialHeader.setText(slide_header[position]);
        tvTutorialContent.setText(slide_content[position]);
        //Add a view ao container
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
