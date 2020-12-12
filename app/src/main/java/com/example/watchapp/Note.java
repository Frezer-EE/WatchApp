package com.example.watchapp;

class Note {
    String id, noteText;

    public Note(String id, String noteText) {
        this.id = id;
        this.noteText = noteText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
