package com.geekbrains.lavsam.notes.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.geekbrains.lavsam.notes.R;
import com.geekbrains.lavsam.notes.domain.Notes;
import com.geekbrains.lavsam.notes.ui.details.NotesDetailsActivity;
import com.geekbrains.lavsam.notes.ui.details.NotesDetailsFragment;
import com.geekbrains.lavsam.notes.ui.list.NotesListFragment;

public class MainActivity extends AppCompatActivity implements NotesListFragment.OnNotesClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onNotesClicked(Notes note) {

        boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);

        if (isLandscape) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.notes_detail_fragment, NotesDetailsFragment.newInstance(note))
                    .commit();

        } else {
            Intent intent = new Intent(this, NotesDetailsActivity.class);
            intent.putExtra(NotesDetailsActivity.ARG_HEAD, note);
            startActivity(intent);
        }
    }
}