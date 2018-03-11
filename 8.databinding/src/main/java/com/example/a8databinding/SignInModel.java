package com.example.a8databinding;

import android.databinding.BaseObservable;

/**
 * Created by ADMIN on 2/26/2018.
 */

public class SignInModel extends BaseObservable {

    // @Bindable
    String username;
    //  @Bindable
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        //  notifyPropertyChanged(BR.password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        //   notifyPropertyChanged(BR.username);
    }
}
