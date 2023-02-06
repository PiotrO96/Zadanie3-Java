package com.example.ps3_multimedia;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddPhotoActivity extends AppCompatActivity{

    EditText Photo_title;
    EditText Photo_subtitle;
    Button Chose_Photo;
    Button Add_photo;
    TextView Url_photo;
    String Path_photo = " ";
    boolean PhotoSelected =false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        Photo_title = findViewById(R.id.EditText_Title);
        Photo_subtitle = findViewById(R.id.EditText_Subtittle);

        Chose_Photo = findViewById(R.id.Button_ChosePhoto);
        Add_photo = findViewById(R.id.Button_AddPhoto);

        Url_photo = findViewById(R.id.TextView_UrlPhoto);


        Add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(PhotoSelected) {
                    Photo.tittle.add(Photo_title.getText().toString());
                    Photo.subtittle.add(Photo_subtitle.getText().toString());

                    Photo.photo_path.add(Path_photo);
                    Toast.makeText(AddPhotoActivity.this, "Added", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }else
                {
                    Toast.makeText(AddPhotoActivity.this, "Chose Photo", Toast.LENGTH_SHORT).show();

                }
            }
        });



        Chose_Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Url_photo.setText(Path_photo);
                Intent get_photo_intent = new Intent();
                get_photo_intent.setType("image/*");
                get_photo_intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(get_photo_intent,1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
            if (requestCode == 1) {
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    Photo.photo_uri.add(uri);
                    Path_photo = uri.toString();
                    Log.d("Uri", uri.toString());
                    PhotoSelected =true;
                }
            }
            super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
