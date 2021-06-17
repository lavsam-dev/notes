package com.geekbrains.lavsam.notes.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geekbrains.lavsam.notes.R;
import com.geekbrains.lavsam.notes.domain.Notes;

public class NotesDetailsActivity extends AppCompatActivity {

    public static final String ARG_HEAD = "ARG_HEAD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_details);

        if (savedInstanceState == null) {

            Notes note = getIntent().getParcelableExtra(ARG_HEAD);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, NotesDetailsFragment.newInstance(note))
                    .commit();

        }
    }
}