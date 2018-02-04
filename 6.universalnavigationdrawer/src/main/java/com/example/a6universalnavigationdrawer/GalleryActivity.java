package com.example.a6universalnavigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GalleryActivity extends NavigationDrawerActivity {

    Button slideShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_gallery);

        slideShow = findViewById(R.id.button_ShowSlideShow);
        slideShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GalleryActivity.this, SlideShowActivity.class));
            }
        });
    }


}
