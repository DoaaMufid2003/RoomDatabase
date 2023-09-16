package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Update;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomdatabase.Room.Car;
import com.example.roomdatabase.Room.My_Lestiner;
import com.example.roomdatabase.databinding.ActivityMainBinding;

import com.example.roomdatabase.Room.My_ViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Interface, My_Lestiner {
    ActivityMainBinding binding;
    My_ViewModel viewModel;
    List<Car> carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(My_ViewModel.class);
        viewModel.getAllCars().observe(this, new Observer<List<Car>>() {
                    @Override
                    public void onChanged(List<Car> cars) {
                        carList = cars;
                        Adapter adapter = new Adapter(getBaseContext(), carList, MainActivity.this);
                        binding.recycler.setAdapter(adapter);
                        binding.recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
                    }
                }
        );
        binding.imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDelete(int postion) {

        Car car = carList.get(postion);
        viewModel.delete(car);
    }

    @Override
    public void onEdit(int postion) {
        BlankFragment fragment = BlankFragment.newInstance(postion, carList.get(postion).getCar_name(), carList.get(postion).getCar_color(), carList.get(postion).getYear());
        fragment.show(getSupportFragmentManager(), null);


//        Car car=carList.get(postion);
//    Intent intent=new Intent(getBaseContext(), UpdateActivity.class);
//    intent.putExtra("name",carList.get(postion).getCar_name());
//    intent.putExtra("year",carList.get(postion).getYear());
//    intent.putExtra("color",carList.get(postion).getCar_color());
//    intent.putExtra("id",car.getId());
//    startActivity(intent);


    }

    @Override
    public void editcar(int postion, String carname, int year, String color) {

        viewModel.update(new Car(carList.get(postion).getId(), carname, color, year));
    }
}