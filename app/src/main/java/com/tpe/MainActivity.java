package com.tpe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextMessage;
    private FrameLayout OnOff;
    private FrameLayout Parasol;
    private FrameLayout Ombre;
    private FrameLayout Infos;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            OnOff.setVisibility(FrameLayout.INVISIBLE);
            Parasol.setVisibility(FrameLayout.INVISIBLE);
            Ombre.setVisibility(FrameLayout.INVISIBLE);
            Infos.setVisibility(FrameLayout.INVISIBLE);

            switch (item.getItemId()) {
                case R.id.power_home:
                    mTextMessage.setText("Power");
                    OnOff.setVisibility(FrameLayout.VISIBLE);
                    return true;
                case R.id.parasol_home:
                    mTextMessage.setText("Parasol");
                    Parasol.setVisibility(FrameLayout.VISIBLE);
                    return true;
                case R.id.ombre_home:
                    mTextMessage.setText("Ombre");
                    Ombre.setVisibility(FrameLayout.VISIBLE);
                    return true;
                case R.id.infos_home:
                    mTextMessage.setText("Infos");
                    Infos.setVisibility(FrameLayout.VISIBLE);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OnOff = findViewById(R.id.OnOff);
        Parasol = findViewById(R.id.Parasol);
        Ombre = findViewById(R.id.Ombre);
        Infos = findViewById(R.id.Infos);
        OnOff.setVisibility(FrameLayout.VISIBLE);

        ImageView ButOnclick = (ImageView) findViewById(R.id.ButOn);
        ButOnclick.setOnClickListener(this);
        ImageView ButOffclick = (ImageView) findViewById(R.id.ButOff);
        ButOffclick.setOnClickListener(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.ButOn: {
                mTextMessage.setText("click On");
                break;
            }
            case  R.id.ButOff: {
                mTextMessage.setText("click Off");
                break;
            }
            //.... etc
        }
    }
}
