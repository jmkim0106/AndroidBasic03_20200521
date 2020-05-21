package com.example.androidbasic03_20200521;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidbasic03_20200521.databinding.ActivityEditEmailBinding;

public class EditEmailActivity extends BaseActivity {

    ActivityEditEmailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_edit_email);
        setUpEvents();
        setValues();
    }

    @Override
    public void setUpEvents() {

        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.emailEdt.getText().toString();

                Intent myIntent = new Intent();
                myIntent.putExtra("editEmail", email);

                setResult(RESULT_OK, myIntent);

                finish();
            }
        });

    }

    @Override
    public void setValues() {

    }
}
