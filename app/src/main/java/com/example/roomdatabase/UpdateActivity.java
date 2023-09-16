package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.roomdatabase.Room.Car;
import com.example.roomdatabase.Room.My_ViewModel;
import com.example.roomdatabase.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {
ActivityUpdateBinding binding;
    My_ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.updateEtColor.setText(getIntent().getStringExtra("color"));
        binding.updateEtYear.setText(String.valueOf(getIntent().getIntExtra("year",0)));
        binding.updateEtName.setText(getIntent().getStringExtra("name"));


        viewModel=new ViewModelProvider(this).get(My_ViewModel.class);
        binding.updateBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int id=  getIntent().getIntExtra("id",0);
                getIntent().getStringExtra("color");
                String name=binding.updateEtName.getText().toString();
                int year=Integer.parseInt(binding.updateEtYear.getText().toString());
                String color=binding.updateEtColor.getText().toString();
                Car car=new Car(id,name,color,year);
                viewModel.update(car);
                Intent intent=new Intent(UpdateActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}