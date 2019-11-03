package com.example.final_project2.MatKul;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.final_project2.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MatkulActivity extends Fragment {
    private Button tambahMatkul;
    private EditText namaMatkul, jumlahSKS, namaDosen;
    MataKuliah mk;
    DatabaseReference reff;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v;
        v = inflater.inflate(R.layout.matkul_fragment, container, false);
        tambahMatkul = v.findViewById(R.id.tambahMatkul);
        namaMatkul = v.findViewById(R.id.namaMatkul);
        jumlahSKS = v.findViewById(R.id.jumlahSks);
        namaDosen = v.findViewById(R.id.namaDosen);
        reff = FirebaseDatabase.getInstance().getReference().child("MataKuliah");
        tambahMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mk = new MataKuliah(namaMatkul.getText().toString(), jumlahSKS.getText().toString(), namaDosen.getText().toString());
                reff.push().setValue(mk);
                Toast.makeText(getActivity(), "berhasil menambahkan", Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }


}
