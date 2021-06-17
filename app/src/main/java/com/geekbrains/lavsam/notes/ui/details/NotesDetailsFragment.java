package com.geekbrains.lavsam.notes.ui.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geekbrains.lavsam.notes.R;
import com.geekbrains.lavsam.notes.domain.Notes;

public class NotesDetailsFragment extends Fragment {

    private static final String ARG_HEAD = "ARG_HEAD";

    public static NotesDetailsFragment newInstance(Notes notes) {
        NotesDetailsFragment fragment = new NotesDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_HEAD, notes);
        fragment.setArguments(bundle);
        return fragment;
    }

    public NotesDetailsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView notesHead = view.findViewById(R.id.notes_head);
        TextView notesText = view.findViewById(R.id.notes_text);

        Notes notes = getArguments().getParcelable(ARG_HEAD);

        notesHead.setText(notes.getHead());
        notesText.setText(notes.getText());
    }
}