package com.example.prateek.studyapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.prateek.studyapp.Activity.StudentLogin;
import com.example.prateek.studyapp.Activity.StudentRegistration;
import com.example.prateek.studyapp.Activity.TeacherLogin;
import com.example.prateek.studyapp.Activity.TeacherRegistration;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_main, container, false);

        Button student = (Button) mView.findViewById(R.id.button);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StudentRegistration.class);
                startActivity(intent);
            }
        });


        Button teacher = (Button) mView.findViewById(R.id.button2);
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TeacherRegistration.class);
                startActivity(intent);
            }
        });

        Button stu_login = (Button) mView.findViewById(R.id.student);
        stu_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StudentLogin.class);
                startActivity(intent);
            }
        });

        Button teach_login = (Button) mView.findViewById(R.id.teacher);
        teach_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TeacherLogin.class);
                startActivity(intent);
            }
        });
        return mView;
    }
}
