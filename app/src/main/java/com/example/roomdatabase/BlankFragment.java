package com.example.roomdatabase;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.roomdatabase.Room.Car;
import com.example.roomdatabase.Room.My_Lestiner;
import com.example.roomdatabase.databinding.FragmentBlankBinding;

public class BlankFragment extends DialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_NAME = "name";
    private static final String ARG_COLOR = "color";
    private static final String ARG_YEAR = "year";
    private static final String ARG_POSITION = "position";
    My_Lestiner lestiner;

    // TODO: Rename and change types of parameters
    private String name;
    private String color;
    private int year;
    private int position;

    public BlankFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(int position, String name, String color, int year) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_COLOR, color);
        args.putInt(ARG_YEAR, year);
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            color = getArguments().getString(ARG_COLOR);
            year = getArguments().getInt(ARG_YEAR);
            position = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        lestiner = (My_Lestiner) context;
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentBlankBinding binding = FragmentBlankBinding.inflate(inflater, container, false);
        binding.updateEtColor.setText(color);
        binding.updateEtName.setText(name);
        binding.updateEtYear.setText(String.valueOf(year));
        binding.updateBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = binding.updateEtColor.getText().toString();
                lestiner.editcar(position, binding.updateEtName.getText().toString(), Integer.parseInt(binding.updateEtYear.getText().toString()), color);
                dismiss();
            }
        });
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }
}