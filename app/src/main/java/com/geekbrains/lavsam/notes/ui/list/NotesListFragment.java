package com.geekbrains.lavsam.notes.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geekbrains.lavsam.notes.R;
import com.geekbrains.lavsam.notes.domain.Notes;
import com.geekbrains.lavsam.notes.domain.NotesRepository;
import com.geekbrains.lavsam.notes.domain.NotesRepositoryImpl;

import java.util.List;

public class NotesListFragment extends Fragment {

    private NotesRepository notesRepository;
    private OnNotesClicked onNotesClicked;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnNotesClicked) {
            onNotesClicked = (OnNotesClicked) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        onNotesClicked = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notesRepository = new NotesRepositoryImpl();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout notesList = view.findViewById(R.id.notes_list_container);

        List<Notes> notes = notesRepository.getNotes();

        for (Notes note : notes) {
            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_notes, notesList, false);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onNotesClicked != null) {
                        onNotesClicked.onNotesClicked(note);
                    }

                }
            });

            TextView notesHead = itemView.findViewById(R.id.notes_head);
            notesHead.setText(note.getHead());

            notesList.addView(itemView);
        }


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public interface OnNotesClicked {
        void onNotesClicked(Notes note);
    }
}
