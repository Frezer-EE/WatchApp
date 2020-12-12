package com.example.watchapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class NoteRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<Note> noteList;
    Context context;

    public NoteRecyclerAdapter(ArrayList<Note> noteList, Context context) {
        this.noteList = noteList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View root = inflater.inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.textView.setText(noteList.get(position).noteText);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.deleteNote(noteList.get(position).id, context);
                notifyItemRemoved(position);
                noteList.remove(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    LinearLayout linearLayout;
    TextView textView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        linearLayout = itemView.findViewById(R.id.linear_note_item);
        textView = itemView.findViewById(R.id.note_item_text);
    }
}
