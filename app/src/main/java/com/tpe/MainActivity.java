package com.tpe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    OnOff.setVisibility(FrameLayout.VISIBLE);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    Parasol.setVisibility(FrameLayout.VISIBLE);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    Ombre.setVisibility(FrameLayout.VISIBLE);
                    return true;
                case R.id.navigation_other:
                    mTextMessage.setText("other");
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

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
