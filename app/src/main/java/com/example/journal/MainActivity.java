package com.example.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Create variables
    EntryDatabase db;
    EntryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = EntryDatabase.getInstance(getApplicationContext());

        adapter = new EntryAdapter(this, db.selectAll());

        // Find list-view and set adapter to it
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // If a grid-item is clicked run class GridItemClickListener
        listView.setOnItemClickListener(new ListItemClickListener());
        listView.setOnItemLongClickListener(new LongItemClickListener());
    }

    // This method is started when the floating button is pressed
    public void addStory(View view){

        // InputActivity is started
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // Create the Cursor
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);

            // Create the intent and put in story variables
            Intent intent  = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra("title", cursor.getString(cursor.getColumnIndex("title")));
            intent.putExtra("content", cursor.getString(cursor.getColumnIndex("content")));
            intent.putExtra("mood", cursor.getString(cursor.getColumnIndex("mood")));
            intent.putExtra("timestamp", cursor.getString(cursor.getColumnIndex("timestamp")));

            // Start the activity
            startActivity(intent);
        }
    }

    private class LongItemClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            // Create the Cursor
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);

            // Delete the journal entry from the table
            Long deleteId = cursor.getLong(cursor.getColumnIndex("_id"));
            db.delete(deleteId);

            // Use updateData method to refresh the screen
            updateData();
            return true;
        }
    }

    // This method updates the adapter
    private void updateData() {
        adapter.swapCursor(db.selectAll());
    }
}
