package com.android.roomarch.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.android.roomarch.Model.Note;
import com.android.roomarch.RoomDB.NoteDao;
import com.android.roomarch.RoomDB.NoteRoomDatabase;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private String TAG = this.getClass().getSimpleName();

    private NoteDao noteDao;
    private NoteRoomDatabase noteDB;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteDB=NoteRoomDatabase.getDatabase(application);
        noteDao=noteDB.noteDao();
        allNotes=noteDao.getAllNotes();
    }

    public void insert(Note note){
        new InsertAsyncTask(noteDao).execute(note);
    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }

    public void update(Note note){
        new UpdateAsyncTask(noteDao).execute(note);
    }
    public void delete(Note note){
        new DeleteAsyncTask(noteDao).execute(note);
    }


    private class OperationsAsyncTask extends AsyncTask<Note, Void, Void>{

        NoteDao mAsyncTaskDao;

        OperationsAsyncTask(NoteDao dao){
            this.mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            return null;
        }
    }

    private class InsertAsyncTask extends OperationsAsyncTask{
        InsertAsyncTask(NoteDao noteDao){
            super(noteDao);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mAsyncTaskDao.insert(notes[0]);
            return null;
        }
    }

    private class UpdateAsyncTask extends OperationsAsyncTask{

        UpdateAsyncTask(NoteDao dao) {
            super(dao);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mAsyncTaskDao.update(notes[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends OperationsAsyncTask{

        DeleteAsyncTask(NoteDao dao) {
            super(dao);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mAsyncTaskDao.delete(notes[0]);
            return null;
        }
    }


}
