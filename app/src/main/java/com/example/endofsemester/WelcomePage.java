package com.example.endofsemester;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WelcomePage extends AppCompatActivity {
    private ImageView showImage;
    private TextView showNameOfStudents;
    private String nameOfStudents = "Sergey Mogilevsky & Oriel Shahino";
    private Intent nextPage;
    private ArrayList<Drawable> images;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcom_page);
        setTheImageView();
        setTheTextView();
        startThread();
        nextPage();
        startThreadTmonot();
        addArrayListImages();
    }


    public void startThreadTmonot() {
        imageView2=findViewById(R.id.imageView_charging);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    for (int i = 0; i <images.size() ; i++)
                    {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        final int finalI = i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView2.setImageDrawable(images.get(finalI));

                            }
                        });

                    }

                }
            }
        }).start();
    }

    public void addArrayListImages() {
        images=new ArrayList<>();
        images.add(getDrawable(R.drawable.n1));
        images.add(getDrawable(R.drawable.n2));
        images.add(getDrawable(R.drawable.n3));

    }




    public void nextPage() {
        nextPage=new Intent(this,MainPage.class);
    }

    public void setTheImageView() {
        showImage =findViewById(R.id.welcome_id_logo);
        showImage.setImageDrawable(getDrawable(R.drawable.eventadvisor_logo_footer));
    }

    public void setTheTextView() {
        showNameOfStudents =findViewById(R.id.made_by_id);
        showNameOfStudents.setText("made by "+ nameOfStudents);
    }

    public void startThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3500);
                    startActivity(nextPage);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
