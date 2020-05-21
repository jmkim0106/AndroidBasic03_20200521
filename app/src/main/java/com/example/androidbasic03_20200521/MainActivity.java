package com.example.androidbasic03_20200521;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidbasic03_20200521.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    final int REQ_FOR_PHONE_NUM = 1002;
    final int REQ_FOR_NICKNAME = 1004;
    final int REQ_FOR_EMAIL = 1006;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setUpEvents();
        setValues();
    }

    @Override
    public void setUpEvents() {

        binding.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                전화걸기 등 안드로이드 => Uri 정보 요구

                Uri myUri = Uri.parse("tel:010-8077-3619");
                Intent myIntent = new Intent(Intent.ACTION_DIAL, myUri);
                startActivity(myIntent);

            }
        });

        binding.editEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(mContext, EditEmailActivity.class);
                startActivityForResult(myIntent, REQ_FOR_EMAIL);

            }
        });

        binding.editPhoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(mContext, EditUserPhoneActivity.class);
                startActivityForResult(myIntent, REQ_FOR_PHONE_NUM);

            }
        });

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext, EditUserNickNameActivity.class);
                startActivityForResult(myIntent, REQ_FOR_NICKNAME);
            }
        };

        binding.editNickNameBtn.setOnClickListener(ocl);

    }

    @Override
    public void setValues() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_FOR_NICKNAME) {
            if (resultCode == RESULT_OK) {

                String nick = data.getStringExtra("editNickName");

                binding.userNickNmaeTxt.setText(nick);

            }
        }
        else if (requestCode == REQ_FOR_PHONE_NUM) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    String phoneNum = data.getStringExtra("phone");
                    binding.userPhoneTxt.setText(phoneNum);
                }
            }
            else {
                Toast.makeText(mContext, "전화번호 변경을 취소했습니다.", Toast.LENGTH_LONG).show();
            }
        }
        else if (requestCode == REQ_FOR_EMAIL) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    String email = data.getStringExtra("email");
                    binding.userEmailTxt.setText(email);
                }
            }
            else {
                Toast.makeText(mContext, "이메일 변경을 취소했습니다.", Toast.LENGTH_LONG).show();
            }
        }

    }
}
