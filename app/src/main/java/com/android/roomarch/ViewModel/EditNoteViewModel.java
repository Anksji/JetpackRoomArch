package com.android.roomarch.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.roomarch.EditNoteActivity;
import com.android.roomarch.Model.Note;
import com.android.roomarch.RoomDB.NoteDao;
import com.android.roomarch.RoomDB.NoteRoomDatabase;

public class EditNoteViewModel extends AndroidViewModel {

    private String TAG=this.getClass().getSimpleName();
    private NoteDao noteDao;
    private NoteRoomDatabase db;


    public EditNoteViewModel(@NonNull Application application) {
        super(application);
        db=NoteRoomDatabase.getDatabase(application);
        noteDao=db.noteDao();
    }

    public LiveData<Note> getNote(String noteId){
        return noteDao.getNote(noteId);
    }
}
