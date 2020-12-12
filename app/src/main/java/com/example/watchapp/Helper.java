package com.example.watchapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Map;

import androidx.wear.activity.ConfirmationActivity;

public class Helper {

    public static String saveNote(Note note, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String id = String.valueOf(System.currentTimeMillis());
        editor.putString(id, note.getNoteText());
        editor.commit();
        return id;
    }

    public static ArrayList<Note> getAllNotes(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        ArrayList<Note> noteArrayList = new ArrayList<>();
        Map<String, ?> key = sharedPreferences.getAll();

        for (Map.Entry<String, ?> entry: key.entrySet()) {
            String data = (String) entry.getValue();
            if (data != null) {
                Note note = new Note(entry.getKey(), data);
                noteArrayList.add(note);
            }
        }
        return  noteArrayList;
    }

    public static void deleteNote(String id, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(id);
        editor.commit();
    }

    public static void displayConfirm(Context context) {
        Intent intent = new Intent(context, ConfirmationActivity.class);
        intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.SUCCESS_ANIMATION);
        intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE, "Note saved");
        context.startActivity(intent);
    }
}
