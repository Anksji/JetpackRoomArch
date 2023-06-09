package com.android.roomarch.RoomDB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.android.roomarch.Model.Note;

@Database(entities = Note.class, version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();

    private static volatile NoteRoomDatabase noteRoomInstance;

    public static NoteRoomDatabase getDatabase(final Context context){
        if (noteRoomInstance==null){
            synchronized (NoteRoomDatabase.class){
                if (noteRoomInstance==null){
                    noteRoomInstance= Room.databaseBuilder(context.getApplicationContext(),
                            NoteRoomDatabase.class,"note_database")
                            .build();
                }
            }
        }
        return noteRoomInstance;
    }

}
