package com.example.a8databinding;

import android.databinding.ObservableField;

/**
 * Created by ADMIN on 2/26/2018.
 */

public class User {

    public final ObservableField<String> firstname = new ObservableField<>();
    public final ObservableField<String> lastname = new ObservableField<>();
    public final ObservableField<Integer> age = new ObservableField<>();
    public final ObservableField<String> gender = new ObservableField<>();
}
