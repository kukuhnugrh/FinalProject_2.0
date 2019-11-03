package com.example.final_project2.Mahasiswa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.final_project2.R;

import java.util.ArrayList;
import java.util.List;

public class MhsAdapter extends RecyclerView.Adapter<MhsAdapter.MyViewHolder> {
    private List<String> mhsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nama, nim;

        public MyViewHolder(View view) {
            super(view);
            nama = (TextView) view.findViewById(R.id.col1);
            nim = (TextView) view.findViewById(R.id.col2);
        }
    }

    public MhsAdapter(ArrayList<String> inputData) {
        mhsList = inputData;
    }

    @Override
    public MhsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dbmhs_list, parent, false);

        return new MhsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MhsAdapter.MyViewHolder holder, int position) {
        holder.nama.setText((CharSequence) mhsList.get(position));
        holder.nim.setText((CharSequence) mhsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mhsList.size();
    }
}
