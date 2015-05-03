package com.palermo_game.palermomobile;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;

/**
 * Created by Julien on 03.05.2015.
 *
 * This fragment serves as a little menue, which enables the user,
 * wether he want's to log in or register.
 *
 */
public class fragment_launch extends Fragment {

    private Button btn_register;
    private Button btn_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.launch_main, container, false);

        btn_register = (Button) v.findViewById(R.id.btn_main_register);
        btn_login    = (Button) v.findViewById(R.id.btn_main_login);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtn_Register();;
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtn_Login();
            }
        });

        return v;
    }

    public void onBtn_Register()
    {

    }

    public void onBtn_Login()
    {
        getFragmentManager().beginTransaction()
                // .add(R.id.launch_view, new fragment_launch_login())
                .replace(R.id.launch_view, new fragment_launch_login())
                .addToBackStack(null)
                .commit();
    }
}
