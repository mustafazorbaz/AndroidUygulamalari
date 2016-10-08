package com.example.mustafazorbaz.restfulwebservice;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mustafazorbaz on 02.09.2016.
 */
public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;
    Query query;
    TextView city;
    TextView degree;
    TextView waether;
    TextView date;
    ImageView img;

    private String CITY = "izmir";
    private String COUNTRY = "Turkey";
    public ViewPagerAdapter(Context context, Query query,String city,String country) {
        this.query=query;
        this.CITY=city;
        this.COUNTRY=country;
        this.context = context;
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container, false);

        city = (TextView) itemView.findViewById(R.id.textViewCity);
        date = (TextView) itemView.findViewById(R.id.textViewDate);
        img = (ImageView) itemView.findViewById(R.id.imageView);
        degree = (TextView) itemView.findViewById(R.id.textViewDegree);
        waether = (TextView) itemView.findViewById(R.id.textViewWeather);

        String status = query.getResults().getChannel().getItem().getCondition().getText().toString();
        city.setText(CITY.toString());
        date.setText(query.getResults().getChannel().getItem().getCondition().getDate().toString());
        waether.setText(status);
        int feh = Integer.parseInt(query.getResults().getChannel().getItem().getCondition().getTemp());
        int cel = (int) ((feh - 32) / 1.8000);
        degree.setText(cel + "℃");
        if (status.equals("Sunny"))
            img.setImageResource(R.drawable.sunny);
        if (status.equals("Partly Cloudy"))
            img.setImageResource(R.drawable.partly_cloudy);
        if (status.equals("Mostly Cloudy"))
            img.setImageResource(R.drawable.cloudy);
        if (status.equals("Clear"))
            img.setImageResource(R.drawable.clear);


        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);
        return itemView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
