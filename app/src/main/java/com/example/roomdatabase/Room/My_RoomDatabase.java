package com.example.roomdatabase.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Car.class}, version = 1, exportSchema = false)
        public abstract class My_RoomDatabase extends RoomDatabase {
        public abstract CarDao CarDao();

        private static volatile My_RoomDatabase INSTANCE;
        private static final int NUMBER_OF_THREADS = 4;
        static final ExecutorService databaseWriteExecutor =
                Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static My_RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (My_RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            My_RoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}

