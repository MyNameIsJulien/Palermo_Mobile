package com.palermo_game.palermomobile;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;

import Core.Session;

/**
 * Created by Julien on 03.05.2015.
 *
 * This fragment is going to be the login page for the application.
 *
 */
public class fragment_launch_login extends Fragment {

    private Button btn_login;
    private EditText edit_username;
    private EditText edit_password;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.launch_login, container, false);
        // TODO:
        //  - Create layout, replace ID with null above ; done
        //  - retrieve button references ect.
        //

        edit_username = (EditText) v.findViewById(R.id.edit_login_username);
        edit_password = (EditText) v.findViewById(R.id.edit_login_password);
        btn_login = (Button) v.findViewById(R.id.btn_login);
        // btn_login.setEnabled(false);

        edit_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btn_login.setEnabled((edit_username.getText().toString().length()>0 && edit_password.getText().toString().length()>0));
            }
        });
        edit_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btn_login.setEnabled((edit_username.getText().toString().length()>0 && edit_password.getText().toString().length()>0));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn();
            }
        });

        return v;
    }

    public void logIn()
    {

        Log.v("App.Login","Button clicked!");

        if(null == Session.logIn(edit_username.getText().toString(), edit_password.getText().toString()))
            return;
        else
        {
            Log.v("App.Login","Starting intent");
            Intent intent = new Intent(getActivity(), Main.class);
            startActivity(intent);
        }
    }


}

