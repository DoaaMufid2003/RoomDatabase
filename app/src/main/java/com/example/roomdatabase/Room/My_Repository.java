package com.example.roomdatabase.Room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class My_Repository {

    private CarDao CarDao;
    private LiveData<List<Car>> allcar;

    My_Repository(Application application) {
        My_RoomDatabase db = My_RoomDatabase.getDatabase(application);
        CarDao = db.CarDao();
        allcar=CarDao.getAllCars();
    }

    void insert(Car car){
        My_RoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                CarDao.insert(car);
            }
        });
    }
    void update(Car car){
        My_RoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                CarDao.update(car);
            }
        });
    }
    void delete(Car car){
        My_RoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                CarDao.delete(car);
            }
        });
    }
    LiveData<List<Car>>  getAllCars(){
    return CarDao.getAllCars();
    }

}
