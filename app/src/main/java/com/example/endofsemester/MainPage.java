package com.example.endofsemester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainPage extends AppCompatActivity {
    private ImageView showImageMeniu;
    private ImageButton filters;
    private ImageButton gps;
    private Intent goTonextPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        setTheImageView();
        setImageButtens();
        klickFiltersBuutten();
        klickGpsBuutten();


    }
    private void nextGoToPage(Class classType) {
        goTonextPage =new Intent(this,classType);
        startActivity(goTonextPage);
    }



    public void setTheImageView() {
        showImageMeniu =findViewById(R.id.logo_id_main_meniu);
        showImageMeniu.setImageDrawable(getDrawable(R.drawable.eventadvisor_logo_footer));
    }
public void setImageButtens(){
        filters = findViewById(R.id.filters_butten);
        gps=findViewById(R.id.gps_butten);

}



    public void klickFiltersBuutten() {
        filters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextGoToPage(SearchByfilters.class);

            }
        });
    }
    public void klickGpsBuutten() {
        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextGoToPage(MapsActivity.class);

            }
        });
    }
}
