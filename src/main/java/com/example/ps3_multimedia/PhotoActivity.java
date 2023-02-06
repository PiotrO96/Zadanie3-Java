package com.example.ps3_multimedia;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PhotoActivity extends AppCompatActivity {


    int idphoto;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        idphoto = getIntent().getIntExtra("idPhoto", 0);

        ImageView photo = findViewById(R.id.photoImageView);
        textView = findViewById(R.id.textTextView);
        photo.setImageURI(Photo.photo_uri.get(idphoto));

        textView.setText(Photo.tittle.get(idphoto)+"  "+Photo.subtittle.get(idphoto)+" - ");

    }
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
