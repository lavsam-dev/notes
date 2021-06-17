package com.geekbrains.lavsam.notes.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

public class Notes implements Parcelable {

    public Notes(int head, int text) {
        this.head = head;
        this.text = text;
    }

    @StringRes
    private int head;
    private int text;

    protected Notes(Parcel in) {
        head = in.readInt();
        text = in.readInt();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public int getHead() {
        return head;
    }

    public int getText() {
        return text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(head);
        dest.writeInt(text);
    }
}
