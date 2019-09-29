package com.example.final_project2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.final_project2.R;
import com.example.final_project2.Service.MyJobService;

import static android.content.Context.JOB_SCHEDULER_SERVICE;
import static androidx.constraintlayout.motion.widget.MotionScene.TAG;

public class MainFragment extends Fragment {
    Button buttonKeluar;
    Button buttonAbout;
    Button buttonStart;
    Button buttonStop;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v;
        v = inflater.inflate(R.layout.main_fragment, container, false);
        buttonKeluar = v.findViewById(R.id.keluar);
        buttonKeluar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent main = new Intent(getActivity(), LoginActivity.class);
                startActivity(main);
            }
        });

        buttonStart = v.findViewById(R.id.jobstart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                ComponentName componentName = new ComponentName(getActivity(), MyJobService.class);
                JobInfo info = new JobInfo.Builder(123, componentName)
                        .setRequiresCharging(true)
                        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                        .setPersisted(true)
                        .setPeriodic(15 * 60 * 1000)
                        .build();

                JobScheduler scheduler = (JobScheduler) getActivity().getSystemService(JOB_SCHEDULER_SERVICE);
                int resultCode = scheduler.schedule(info);
                if (resultCode == JobScheduler.RESULT_SUCCESS) {
                    Log.d(TAG, "Job scheduled");
                } else {
                    Log.d(TAG, "Job scheduling failed");
                }
            }
        });

        buttonStop = v.findViewById(R.id.jobcancel);
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                JobScheduler scheduler = (JobScheduler) getActivity().getSystemService(JOB_SCHEDULER_SERVICE);
                scheduler.cancel(123);
                Log.d(TAG, "Job cancelled");
            }
        });

        buttonAbout = v.findViewById(R.id.tentang);
        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(getActivity(), About.class);
                startActivity(main);
            }
        });

        return v;
    }
}
