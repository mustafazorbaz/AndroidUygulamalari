package com.example.mustafazorbaz.listrunningapps;


import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mustafazorbaz on 15.08.2016.
 */
public class AppAdapter extends RecyclerView.Adapter<AppAdapter.MyAppHolder>{
    private List<App> appsList;
    private ImageView icon;
    public  AppAdapter(List<App> list){
        this.appsList=list;
    }
    public  class MyAppHolder extends  RecyclerView.ViewHolder {
        public TextView appName;
        public ImageView icon;
        public MyAppHolder(View view)
        {

            super(view);
            appName=(TextView) view.findViewById(R.id.appName);
            icon=(ImageView) view.findViewById(R.id.imageView);
        }
    }
    @Override
    public MyAppHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_list_row,parent,false);
        return new MyAppHolder(itemView);    }

    @Override
    public void onBindViewHolder(MyAppHolder holder, int position) {
        App app =appsList.get(position);
        holder.appName.setText(app.getAppName());
        holder.icon.setImageDrawable(app.getIcon());
    }
    @Override
    public int getItemCount() {
        return appsList.size();
    }
}
