package com.example.journal;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class InputActivity extends AppCompatActivity {

    String selectedMood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void addEntry(View view){

        // Get the title, content and mood
        EditText titleView = findViewById(R.id.inputTitle);
        String title = titleView.getText().toString();

        EditText contentView = findViewById(R.id.inputContent);
        String content = contentView.getText().toString();

        String mood = selectedMood;

        // Create a new JournalEntry
        JournalEntry journal = new JournalEntry(null, title, content, mood, null);

        // Get the database
        EntryDatabase db = EntryDatabase.getInstance(this);

        // Insert JournalEntry to the database
        db.insert(journal);

        // Create activity
        Intent intent = new Intent(this, MainActivity.class);

        // Start new intent
        startActivity(intent);
    }

    public void selectMood(View view) {
        // Use a switch to get the mood that was selected
        switch (view.getId()) {
            default:
                selectedMood = "";
                break;
            case R.id.happy:
                selectedMood = "happy";
                break;
            case R.id.angry:
                selectedMood = "angry";
                break;
            case R.id.sad:
                selectedMood = "sad";
                break;
            case R.id.confused:
                selectedMood = "confused";
                break;
            case R.id.love:
                selectedMood = "love";
                break;
        }
//        view.setBackgroundColor(Color.BLACK);
    }
}
