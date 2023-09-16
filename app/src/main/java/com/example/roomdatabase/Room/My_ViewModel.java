package com.example.roomdatabase.Room;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class My_ViewModel extends AndroidViewModel {

        private My_Repository mRepository;

        public My_ViewModel (Application application) {
            super(application);
            mRepository = new My_Repository(application);
        }
   public void insert(Car car){

            mRepository.insert(car);
    }
   public void update(Car car){
            mRepository.update(car);
    }
   public void delete(Car car){
            mRepository.delete(car);

    }
  public   LiveData<List<Car>>  getAllCars(){
        return mRepository.getAllCars();
    }


}

