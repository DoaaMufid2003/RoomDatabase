package com.example.roomdatabase.Room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Car {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @NonNull
    public String Car_name;
    public String Car_color;
    public int Year;

    public Car(int id, @NonNull String car_name, String car_color, int year) {
        this.id = id;
        Car_name = car_name;
        Car_color = car_color;
        Year = year;
    }

    public Car(@NonNull String car_name, String car_color, int year) {
        Car_name = car_name;
        Car_color = car_color;
        Year = year;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getCar_name() {
        return Car_name;
    }

    public void setCar_name(@NonNull String car_name) {
        Car_name = car_name;
    }

    public String getCar_color() {
        return Car_color;
    }

    public void setCar_color(String car_color) {
        Car_color = car_color;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }
}
