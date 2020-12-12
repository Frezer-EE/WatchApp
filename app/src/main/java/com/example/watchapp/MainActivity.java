package com.example.watchapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends WearableActivity {
    RecyclerView recyclerView;
    ArrayList<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.note_recycler);
        noteList = new ArrayList<>();
        updateUserInterface();

        // Enables Always-on
//        setAmbientEnabled();
    }

    public void updateUserInterface() {
        noteList = Helper.getAllNotes(this);
        recyclerView.setAdapter(new NoteRecyclerAdapter(noteList, this));
    }

    public void addNoteOnClick(View view) {
        Note note = new Note(null, "Test note");
        Helper.saveNote(note, this);
        Helper.displayConfirm(this);
        updateUserInterface();

//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Скажите назвние");
//        startActivityForResult(intent, 1001);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 1001 && resultCode == RESULT_OK) {
//            String message = data.getStringExtra(RecognizerIntent.EXTRA_RESULTS);
//            Note note = new Note(null, message);
//            Helper.saveNote(note, this);
//            Helper.displayConfirm(this);
//            updateUserInterface();
//        }
//    }
}