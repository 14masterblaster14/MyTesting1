package com.example.a8databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

/**
 * Created by ADMIN on 2/26/2018.
 */

public class SignInViewModel extends BaseObservable {

    @Bindable
    private SignInModel signInModel;
    @Bindable
    private String errorUsername;

    public @NonNull
    SignInModel getSignInModel() {
        if (null == signInModel) {
            signInModel = new SignInModel();
        }
        return signInModel;
    }

    public String getErrorUsername() {
        return errorUsername;
    }

    public void setErrorUsername(String errorUsername) {
        this.errorUsername = errorUsername;
        // notifyPropertyChanged(BR.errorUsername);
    }
}
