package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomdatabase.Room.Car;
import com.example.roomdatabase.Room.My_ViewModel;
import com.example.roomdatabase.databinding.ActivityAddBinding;

import java.util.List;

public class AddActivity extends AppCompatActivity {
ActivityAddBinding binding;
My_ViewModel viewModel;
Adapter adapter;
MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.addBtnAddcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel=new ViewModelProvider(AddActivity.this).get(My_ViewModel.class);
                String name=binding.addEtName.getText().toString();
                int year=Integer.parseInt(binding.addEtYear.getText().toString());
                String color=binding.addEtColor.getText().toString();
                Car car=new Car(name,color,year);
                viewModel.insert(car);

                binding.addEtYear.setText("");
                binding.addEtColor.setText("");
                binding.addEtName.setText("");
            }
        });
    }
}