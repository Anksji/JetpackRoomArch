package com.android.roomarch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNoteActivity extends AppCompatActivity {

    public static final String NOTE_TITLE = "note_title";
    public static final String NOTE_CONTENT = "note_content";

    private EditText etNewNote;
    private EditText etNewNoteContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        etNewNote = findViewById(R.id.etNewNote);
        etNewNoteContent = findViewById(R.id.etNewNoteContent);

        Button button = findViewById(R.id.bAdd);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent resultIntent = new Intent();

                if (TextUtils.isEmpty(etNewNote.getText())) {
                    setResult(RESULT_CANCELED, resultIntent);
                } else {
                    String note = etNewNote.getText().toString();
                    resultIntent.putExtra(NOTE_TITLE, note);
                    resultIntent.putExtra(NOTE_CONTENT, etNewNoteContent.getText().toString());
                    setResult(RESULT_OK, resultIntent);
                }

                finish();
            }
        });
    }
}
