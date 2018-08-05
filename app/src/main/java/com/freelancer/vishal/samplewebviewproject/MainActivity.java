package com.freelancer.vishal.samplewebviewproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText textUrl;

    private Button submitButton;
    private ProgressBar progressBar;
    private static String webUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUrl = findViewById(R.id.TextUrl);
        submitButton = findViewById(R.id.Submit);
        progressBar = findViewById(R.id.progressBar);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);
                webUrl = textUrl.getText().toString();

                Log.e("MainActivity","URL is empty or not" + webUrl);

                if (!TextUtils.isEmpty(webUrl)){

                    Intent intent = new Intent(MainActivity.this,WebPageActivity.class);
                    intent.putExtra("kWebUrl",webUrl);
                    startActivity(intent);

                    progressBar.setVisibility(View.INVISIBLE);


                } else {
                    Toast.makeText(MainActivity.this,"Please provide URl to proceed",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
