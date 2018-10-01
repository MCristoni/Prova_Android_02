package com.fumec.prova02matheuscristoni;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Fragment01 frag1;
    private Fragment02 frag2;
    private android.support.v4.app.FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            frag1 = (Fragment01) manager.findFragmentById(R.id.frame1);
            frag2 = (Fragment02) manager.findFragmentById(R.id.frame2);
            if(frag1 == null){
                frag1 = Fragment01.newInstance();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.frame1, frag1);
                transaction.commit();
            }
            if(frag2 == null){
                frag2 = Fragment02.newInstance("");
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.frame2, frag2);
                transaction.commit();
            }
        }else{
            Fragment01 frag1 = (Fragment01) manager.findFragmentById(R.id.frame_vertical);
            if(frag1 == null){
                frag1 = Fragment01.newInstance();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.frame_vertical, frag1);
                transaction.commit();
            }
        }
    }

    public FragmentManager getManager() {
        return manager;
    }
}
