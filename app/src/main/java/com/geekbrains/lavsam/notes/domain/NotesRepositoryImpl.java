package com.geekbrains.lavsam.notes.domain;

import com.geekbrains.lavsam.notes.R;

import java.util.ArrayList;
import java.util.List;

public class NotesRepositoryImpl implements NotesRepository {

    @Override
    public List<Notes> getNotes() {
        ArrayList<Notes> notes = new ArrayList<>();

        notes.add(new Notes(R.string.head_e_tuvik, R.string.text_e_tuvik));
        notes.add(new Notes(R.string.head_b_guzka, R.string.text_b_guzka));
        notes.add(new Notes(R.string.head_b_sip, R.string.text_b_sip));
        notes.add(new Notes(R.string.head_k_konek, R.string.text_k_konek));
        notes.add(new Notes(R.string.head_o_skvorec, R.string.text_o_skvorec));
        notes.add(new Notes(R.string.head_p_chechetka, R.string.text_p_chechetka));

        return notes;
    }
}
