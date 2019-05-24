package com.example.endofsemester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class SearchByfilters extends AppCompatActivity {
    private List<AuthUI.IdpConfig> providers = Collections.singletonList(
            new AuthUI.IdpConfig.GoogleBuilder().build());

    private Button checkData;
    public static ArrayList<ulam> ulamArrayList = new ArrayList<>();
    public static ArrayList<ulam> resaultUlaml = new ArrayList<>();
    private SeekBar seekBarRange;
    private TextView sumRange;
    private SeekBar seekBarInvited;
    private TextView sumInvited;
    private Spinner spinnerCitys;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_byfilters);
        addNewUlam();
        seekBarInvited = findViewById(R.id.seekBar_invited);
        seekBarRange = findViewById(R.id.seekBar_range);
        radioGroup=findViewById(R.id.radioGroup);
        sumRange = findViewById(R.id.sum_range);
        sumInvited = findViewById(R.id.sum_invited);
        Button button=findViewById(R.id.check_the_data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkTheData();
            }
        });
        metodSeekBarRange();
        metodSeekBarInvited();
        addSpinner();
        onResume();

    }
    private void addNewUlam() {
        ulamArrayList.add(new ulam(20, 200, "חולון",R.drawable.n1,0));
        ulamArrayList.add(new ulam(500, 350, "קריית גת",R.drawable.n1,0));
        ulamArrayList.add(new ulam(300, 300, "יבנה",R.drawable.n1,0));
        ulamArrayList.add(new ulam(500, 290, "אילת",R.drawable.n1,0));
        ulamArrayList.add(new ulam(270, 600, "גן יבנה",R.drawable.n1,0));
        ulamArrayList.add(new ulam(500, 34, "אשקלון",R.drawable.n1,0));
//        ulamArrayList.add(new ulam(500, 34, "vfgh",R.drawable.n1,1));
//        ulamArrayList.add(new ulam(500, 34, "vfgh",R.drawable.n1,2));
//        ulamArrayList.add(new ulam(500, 500, "vfgh",R.drawable.n1,3));
//        ulamArrayList.add(new ulam(500, 500, "vfgh",R.drawable.n1,4));
//        ulamArrayList.add(new ulam(500, 500, "vfgh",R.drawable.n1,4));
//        ulamArrayList.add(new ulam(12, 500, "vfgh",R.drawable.n1,4));
//        ulamArrayList.add(new ulam(500, 500, "vfgh",R.drawable.n1,4));
//        ulamArrayList.add(new ulam(12, 500, "vfgh",R.drawable.n1,0));
//        ulamArrayList.add(new ulam(12, 34, "vfgh",R.drawable.n1,0));
//        ulamArrayList.add(new ulam(12, 34, "vfgh",R.drawable.n1,0));
//        ulamArrayList.add(new ulam(12, 34, "vfgh",R.drawable.n1,0));
//        ulamArrayList.add(new ulam(12, 34, "vfgh",R.drawable.n1,0));


    }

    private void checkTheData() {
        for (ulam object : ulamArrayList) {
            System.out.println(radioGroup.getCheckedRadioButtonId());
            if (
                    seekBarRange.getProgress() <= object.getPrice()
                            && seekBarInvited.getProgress() <= object.getMuzmanim()
                         /*  &&
                            radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId()))==object.getType()
                            &&
                            spinnerCitys.getSelectedItem()==object.getCity()*/


            )
            {
                resaultUlaml.add(object);
            }
        }
       startActivity(new Intent(this,R_V.class));
    }



    @Override
    public void onResume() {
        super.onResume();

        resaultUlaml.clear();
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == 0) {
            } else {
            }
        }
    }


    private void metodSeekBarRange() {

        seekBarRange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                sumRange.setText("" + progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void metodSeekBarInvited() {
        seekBarInvited.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sumInvited.setText("" + progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void addSpinner() {
        Vector<String> str = new Vector<String>();
        BufferedReader in = null;

        int BUFFER_SIZE = 8192;

        try {
            in = new BufferedReader(new InputStreamReader(getAssets().open("city.txt")));
            String line = in.readLine();
            int index = 0;
            while (line != null) {
                str.add(line);
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        spinnerCitys = findViewById(R.id.spinner1);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, str);

        spinnerCitys.setAdapter(adapter);
        spinnerCitys.setSelection(2);

    }
}

