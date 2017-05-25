package com.example.hp.imageviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        String img=getIntent().getExtras().getString("Image");
        Log.d("************","url"+img);
        ImageView fullimage=(ImageView)findViewById(R.id.fullimage);

        Glide.with(this)
                .load(img)
                .into(fullimage);
    }
}
