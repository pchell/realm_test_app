package com.example.realmdatabaseproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realmdatabaseproject.R;
import com.example.realmdatabaseproject.data.database.model.UserNote;

import java.util.List;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public  class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements RealmChangeListener {
    private final RealmResults<UserNote> userNotesResults;

    public RecyclerViewAdapter(RealmResults<UserNote> userNotes) {
        this.userNotesResults = userNotes;
        this.userNotesResults.addChangeListener(this);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_note, parent, false);
        return new ViewHolder((TextView) view);
    }

    @Override
    public void onBindViewHolder    (@NonNull ViewHolder holder, int position) {
        holder.textUserNote.setText(userNotesResults.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return userNotesResults.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onChange(Object o) {
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textUserNote;

        public ViewHolder(final TextView textView) {
            super(textView);
           // itemView.setOnClickListener(this);
            textUserNote = textView;
        }

        @Override
        public void onClick(View v) {

        }
    }
}