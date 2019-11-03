package com.example.final_project2.MatKul;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_project2.R;

import java.util.ArrayList;


public class MatKulAdapter extends RecyclerView.Adapter<MatKulAdapter.ViewHolder> {
    private ArrayList<MataKuliah> rvData;


    public MatKulAdapter(ArrayList<MataKuliah> dataSet) {

        rvData = dataSet;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_matkul;
        public TextView tv_sks;
        public TextView tv_dosen;

        public ViewHolder(View v) {
            super(v);
            tv_matkul = (TextView) v.findViewById(R.id.tv_matkul);
            tv_sks = (TextView) v.findViewById(R.id.tv_sks);
            tv_dosen = (TextView) v.findViewById(R.id.tv_dosen);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dbmhs_list, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.tv_matkul.setText(rvData.get(position).getNamaMatkul());
        holder.tv_sks.setText(rvData.get(position).getJumlahSks());
        holder.tv_dosen.setText(rvData.get(position).getNamaDosen());

        final String matkul = rvData.get(position).getNamaMatkul();
        final String sks = rvData.get(position).getJumlahSks();
        final String dosen = rvData.get(position).getNamaDosen();

        holder.tv_dosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("click recycle view: " + matkul);

            }
        });

    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }
}
