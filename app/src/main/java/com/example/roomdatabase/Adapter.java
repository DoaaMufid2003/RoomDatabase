package com.example.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.roomdatabase.databinding.CustomItemBinding;

import java.io.ByteArrayOutputStream;
import java.util.List;

import com.example.roomdatabase.Room.Car;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    Context context;
    List<Car> carList;
    Interface on_action;
    public Adapter(Context context, List<Car> carList, Interface on_action) {
        this.context = context;
        this.carList = carList;
        this.on_action = on_action;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomItemBinding binding=CustomItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int pos=position;
        holder.color.setText(carList.get(position).getCar_color());
        holder.name.setText(carList.get(position).getCar_name());
        holder.year.setText(String.valueOf(carList.get(position).getYear()));
        holder.Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            on_action.onEdit(pos);
            }

        });
        holder.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on_action.onDelete(pos);
            }
        });

    }

    @Override
    public int getItemCount() {

        return carList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView color;
        TextView year;
        ImageView Edit;
        ImageView close;

        public MyViewHolder(@NonNull CustomItemBinding binding) {
            super(binding.getRoot());

            name=binding.ciTvName;
            color= binding.ciTvColor;;
            year= binding.ciTvYear;;
            Edit=binding.imgEdit;
            close=binding.imgClose;


        }
    }
}