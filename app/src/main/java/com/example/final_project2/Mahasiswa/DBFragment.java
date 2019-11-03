package com.example.final_project2.Mahasiswa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_project2.R;

import java.util.ArrayList;

public class DBFragment extends Fragment {
    private ArrayList<String> dataSet;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private MhsAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v;
        v = inflater.inflate(R.layout.db_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        dataSet = new ArrayList<>();
        initDataset();
        mAdapter = new MhsAdapter(dataSet);
        layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        return v;

    }

    private void initDataset(){
        dataSet.add("Pertama");
        dataSet.add("Kedua");

    }


}
