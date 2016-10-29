package com.blogspot.codigosandroid.calculadora.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.blogspot.codigosandroid.calculadora.R;
import com.blogspot.codigosandroid.calculadora.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().add(R.id.activity_main, new MainFragment()).commit();

        }

    }

}
