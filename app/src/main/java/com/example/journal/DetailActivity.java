package com.example.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get the intent
        Intent intent = getIntent();

        // Get and set the title, date and content
        TextView title = findViewById(R.id.outputTitle);
        TextView date = findViewById(R.id.outputDate);
        TextView content = findViewById(R.id.outputContent);

        title.setText(intent.getStringExtra("title"));
        date.setText(intent.getStringExtra("timestamp"));
        content.setText(intent.getStringExtra("content"));

        // Get and set the mood
        ImageView mood = findViewById(R.id.outputMood);

        switch (intent.getStringExtra("mood")) {
            default:
                mood.setImageResource(R.drawable.happy);
                break;
            case "happy":
                mood.setImageResource(R.drawable.happy);
                break;
            case "angry":
                mood.setImageResource(R.drawable.angry);
                break;
            case "sad":
                mood.setImageResource(R.drawable.sad);
                break;
        }
    }
}
