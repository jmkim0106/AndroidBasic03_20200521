package com.example.androidbasic03_20200521;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext = this;

    public abstract void setUpEvents();
    public abstract void setValues();

}

