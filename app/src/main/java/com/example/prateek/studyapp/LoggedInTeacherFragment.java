package com.example.prateek.studyapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoggedInTeacherFragment extends Fragment {

    public LoggedInTeacherFragment() {
    }
    View mView;

    Button image;
    Button videos;
    Button presentaion;

    private static int RESULT_LOAD_IMG = 1;
    private static int RESULT_LOAD_VIDEO = 1;
    private static int RESULT_LOAD_PRESENT = 1;
    String imgDecodableString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_logged_in_teacher, container, false);
        image = (Button) mView.findViewById(R.id.images);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImagefromGallery();
            }
        });

        videos = (Button) mView.findViewById(R.id.videos);
        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadVideosFromGallery();
            }
        });

        presentaion = (Button) mView.findViewById(R.id.presentation);
        presentaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPresentationsFromGallery();
            }
        });
        return mView;
    }

    public void loadVideosFromGallery(){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_VIDEO);
    }

    public void loadPresentationsFromGallery(){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                Uri.parse(MediaStore.Files.FileColumns.MEDIA_TYPE));
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_PRESENT);
    }

    public void loadImagefromGallery() {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == Activity.RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContext().getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                /*ImageView imgView = (ImageView) findViewById(R.id.imgView);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));*/

            } else if(requestCode == RESULT_LOAD_VIDEO && resultCode == Activity.RESULT_OK && null != data) {

                Uri selectedVideo = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContext().getContentResolver().query(selectedVideo,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();

            }else if(requestCode == RESULT_LOAD_PRESENT && resultCode == Activity.RESULT_OK && null != data){

                Uri selectedPresent = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContext().getContentResolver().query(selectedPresent,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();


            }else {
                Toast.makeText(getContext(), "You haven't picked Image or Video or Presentation", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

}
