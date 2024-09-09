package com.chetan.simplemvvm.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.chetan.simplemvvm.R;
import com.chetan.simplemvvm.databinding.ActivityMainBinding;
import com.chetan.simplemvvm.domain.model.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        ActivityMainBinding mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        loginViewModel=new ViewModelProvider(this).get(LoginViewModel.class);

        mainBinding.setViewmodel(loginViewModel);
        mainBinding.setLifecycleOwner(this);

        loginViewModel.loginResult.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
        });

    }
}