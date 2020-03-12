package com.example.last;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SliderAdapter extends PagerAdapter {
private Context ctx;
private List<slider> mlist;

    public SliderAdapter(Context ctx, List<slider> mlist) {
        this.ctx = ctx;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflae = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLay = inflae.inflate(R.layout.slider,null);

        ImageView slidesimg = sliderLay.findViewById(R.id.slide_img);
        TextView slidestxt = sliderLay.findViewById(R.id.slide_title);
        slidesimg.setImageResource(mlist.get(position).getImage());
        slidestxt.setText(mlist.get(position).getTitle());

        container.addView(sliderLay);
        return sliderLay;

    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
