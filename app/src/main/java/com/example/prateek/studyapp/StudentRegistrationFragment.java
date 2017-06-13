package com.example.prateek.studyapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prateek.studyapp.Model.Registration;
import com.example.prateek.studyapp.Service.StudentService;

import java.io.EOFException;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class StudentRegistrationFragment extends Fragment {

    public StudentRegistrationFragment() {
    }

    Registration registration = new Registration();
    EditText name;
    EditText email;
    EditText password;
    View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_student_registration, container, false);

        name = (EditText) mView.findViewById(R.id.st_name);
        email = (EditText) mView.findViewById(R.id.st_email);
        password = (EditText) mView.findViewById(R.id.st_pass);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sleepy-plains-48469.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final StudentService service = retrofit.create(StudentService.class);

        Button button = (Button) mView.findViewById(R.id.st_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registration.setName(name.getText().toString());
                registration.setEmail(email.getText().toString());
                registration.setPassword(password.getText().toString());

                Call<Registration> createCall = service.update(registration);
                createCall.enqueue(new Callback<Registration>() {
                    @Override
                    public void onResponse(Call<Registration> call, Response<Registration> response) {
                        if (response.body() == null){
                            try{
                                Log.v("Null Response", "Null Data"+ response.errorBody());
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }

                        Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Registration> call, Throwable t) {

                    }
                });
            }
        });

        return mView;
    }
}
