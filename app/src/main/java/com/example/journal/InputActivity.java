package com.example.journal;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    String selectedMood = "";
    ImageButton happy, angry, sad, confused, love;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        happy = findViewById(R.id.happy);
        angry = findViewById(R.id.angry);
        sad = findViewById(R.id.sad);
        confused = findViewById(R.id.confused);
        love = findViewById(R.id.love);

        if (savedInstanceState != null) {
            selectedMood = savedInstanceState.getString("mood");

            switch (selectedMood) {
                case "happy":
                    happy.setBackgroundColor(Color.BLACK);
                    break;
                case "angry":
                    angry.setBackgroundColor(Color.BLACK);
                    break;
                case "sad":
                    sad.setBackgroundColor(Color.BLACK);
                    break;
                case "confused":
                    confused.setBackgroundColor(Color.BLACK);
                    break;
                case "love":
                    love.setBackgroundColor(Color.BLACK);
                    break;
            }
        }
    }

    public void addEntry(View view){

        // Get the title and content
        EditText titleView = findViewById(R.id.inputTitle);
        String title = titleView.getText().toString();
        EditText contentView = findViewById(R.id.inputContent);
        String content = contentView.getText().toString();
        String mood = selectedMood;

        if (title != "" && content != "" && mood != "") {
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
        else {
            Toast.makeText(this, "All fields must be filled in!", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String mood = selectedMood;
        outState.putString("mood", mood);
    }

    public void selectMood(View view) {

        // Set Background to white of all ImageButtons
        happy.setBackgroundColor(Color.WHITE);
        angry.setBackgroundColor(Color.WHITE);
        sad.setBackgroundColor(Color.WHITE);
        confused.setBackgroundColor(Color.WHITE);
        love.setBackgroundColor(Color.WHITE);

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
      view.setBackgroundColor(Color.BLACK);
    }
}
