package com.android.roomarch.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "notes")
public class Note {

    @NonNull
    public String getId(){
        return id;
    }

    @NonNull
    public String getNoteTitle(){
        return this.noteTitle;
    }

    @NonNull
    public String getNoteContent(){
        return  this.noteContent;
    }

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name="note_title")
    private String noteTitle;

    @NonNull
    @ColumnInfo(name = "note_content")
    private String noteContent;

    public Note(@NonNull String id, @NonNull String noteTitle, @NonNull String noteContent) {
        this.id = id;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }
}
