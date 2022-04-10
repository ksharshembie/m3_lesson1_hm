package com.ksharshembie.m2_lesson1_hm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText emailAddress, emailTitle, emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailAddress = findViewById(R.id.target_email);
        emailTitle = findViewById(R.id.subject_email);
        emailText = findViewById(R.id.message);
        Button sendEmail = findViewById(R.id.btn_send);
        sendEmail.setOnClickListener(view -> {
            if (!emailAddress.getText().toString().isEmpty() && !emailTitle.getText().toString().isEmpty()
                    && !emailText.getText().toString().isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT, emailTitle.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, emailText.getText().toString());
                intent.setData(Uri.parse("mailto:"));
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, R.string.please_fill_all_fields, Toast.LENGTH_SHORT).show();
            }
        });
    }
}