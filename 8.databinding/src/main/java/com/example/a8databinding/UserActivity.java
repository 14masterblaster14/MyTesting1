package com.example.a8databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.a8databinding.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_user);
        ActivityUserBinding activityUserBinding = DataBindingUtil.setContentView(this, R.layout.activity_user);
        User user = new User("Tony", "Stark", 35, "Male");
        activityUserBinding.setUser(user);
    }
}
