package com.example.mustafazorbaz.listrunningapps;

import android.view.View;

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
