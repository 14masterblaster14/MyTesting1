package com.example.a8databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.a8databinding.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {
    public static final String TAG = UserActivity.class.getSimpleName();
    private ActivityUserBinding activityUserBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_user);
        activityUserBinding = DataBindingUtil.setContentView(this, R.layout.activity_user);
        //User1 user = new User1("Tony", "Stark", 35, "Male");
        User1 user = new User1();
        user.setFirstName("Sachin");
        user.setLastName("Tendulkar");
        user.setAge(40);
        user.setGender("Male");
        activityUserBinding.setUser1(user);
    }
}
