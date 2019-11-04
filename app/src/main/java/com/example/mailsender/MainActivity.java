package com.example.mailsender;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtEmailer = findViewById(R.id.edtEmail);
        final EditText edtEmailText = findViewById(R.id.edtText);
        final EditText edtSubject = findViewById(R.id.txtSubject);
        Button btnSend = findViewById(R.id.btnSend);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailer = String.valueOf(edtEmailer.getText());
                String subject = String.valueOf(edtSubject.getText());
                String emailText = String.valueOf(edtEmailText.getText());
                String mailto = "mailto:" + Uri.encode(emailer) +
                        "?subject=" + Uri.encode(subject) +
                        "&body=" + Uri.encode(emailText);
                SendEmail(emailIntent,mailto);



            }
        });


    }
    void SendEmail(Intent emailIntent,String mail){
        emailIntent.setData(Uri.parse(mail));
        startActivity(emailIntent);
    }


}
