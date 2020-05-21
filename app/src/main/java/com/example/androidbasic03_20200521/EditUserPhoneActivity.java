package com.example.androidbasic03_20200521;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidbasic03_20200521.databinding.ActivityEditUserPhoneBinding;

public class EditUserPhoneActivity extends BaseActivity {

    ActivityEditUserPhoneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_user_phone);
        setUpEvents();
        setValues();
    }

    @Override
    public void setUpEvents() {

        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputPhoneNum = binding.phoneNumEdit.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("phone", inputPhoneNum);

                setResult(RESULT_OK, resultIntent);

                finish();

            }
        });

    }

    @Override
    public void setValues() {

    }
}
