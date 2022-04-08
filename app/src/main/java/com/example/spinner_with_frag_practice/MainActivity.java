package com.example.spinner_with_frag_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

//  Declaring objects variables

    Fragment1 mFragmentOne;
    fragment2 mFragmentTwo;
    fragment3 mFragmentThree;

    boolean mIsPlaying = false;

    Spinner spinner;
    List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);

//  creating new objects

        mFragmentOne = new Fragment1();
        mFragmentTwo = new fragment2();
        mFragmentThree = new fragment3();

//  creating new list and
//  adding some items

 //       names = new ArrayList<>();

//        names.add("Batman");
//        names.add("Iron Man");
//        names.add("Spider Man");

//   putting the names
//   into items
//   using array adapter .

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);

//  connecting array adapter
//  with spinner

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // adding onItemSelectedListener
        // to select items
        // from spinner

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        selectFragment(mFragmentOne);
                        stopService(new  Intent(MainActivity.this, NewServiceIronman.class));
                        stopService(new  Intent(MainActivity.this, NewServiceSpiderman.class));
                        startService(new Intent(MainActivity.this, NewServiceBatman.class));
                            break;
                    case 1:
                        selectFragment(mFragmentTwo);
                        stopService(new Intent(MainActivity.this, NewServiceBatman.class));
                        stopService(new  Intent(MainActivity.this, NewServiceSpiderman.class));
                        startService(new Intent(MainActivity.this, NewServiceIronman.class));
                            break;
                    case 2:
                        selectFragment(mFragmentThree);
                        stopService(new Intent(MainActivity.this, NewServiceBatman.class));
                        stopService(new  Intent(MainActivity.this, NewServiceIronman.class));
                        startService(new Intent(MainActivity.this, NewServiceSpiderman.class));
                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    private void selectFragment(Fragment frag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,frag);
        fragmentTransaction.commit();
    }
}