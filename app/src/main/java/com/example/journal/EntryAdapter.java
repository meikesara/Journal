package com.example.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {

    // Create constructor
    public EntryAdapter(Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor, true);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Initialise variables
        int columnIndex;
        TextView title = view.findViewById(R.id.title);
        TextView timestamp = view.findViewById(R.id.date);

        // Get the title from the database and set the textview
        columnIndex = cursor.getColumnIndex("title");
        title.setText(cursor.getString(columnIndex));

        // Get the content from the database and set the textview
        columnIndex = cursor.getColumnIndex("timestamp");
        timestamp.setText("Date: " + cursor.getString(columnIndex));

        ImageView mood = view.findViewById(R.id.mood);

        // Get and Set the mood
        switch (cursor.getString(cursor.getColumnIndex("mood"))) {
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
            case "confused":
                mood.setImageResource(R.drawable.confused);
                break;
            case "love":
                mood.setImageResource(R.drawable.love);
                break;
        }
    }
}
