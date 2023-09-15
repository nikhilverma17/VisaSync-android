package com.example.visasync;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the TextView
        TextView linkTextView = findViewById(R.id.linkTextView);

        // Create a ClickableSpan for the link
        SpannableString spannableString = new SpannableString(linkTextView.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Define the URL to open
                String url = "https://visasync.onrender.com/";

                // Create an Intent to open a web browser
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                // Start the activity
                startActivity(intent);
            }
        };

        // Apply the ClickableSpan to the link text
        spannableString.setSpan(clickableSpan, 0, linkTextView.getText().length(), 0);
        linkTextView.setText(spannableString);

        // Make sure the links are clickable
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}