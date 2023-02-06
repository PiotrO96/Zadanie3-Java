package com.example.ps3_multimedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    ListView listView_photo;
    Button photo_add_button;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adapter = new Adapter(this, Photo.tittle, Photo.subtittle, Photo.photo_uri);
        listView_photo = (ListView) findViewById(R.id.listView_ListPhoto);
        photo_add_button = (Button) findViewById(R.id.button_add_photo);

        listView_photo.setAdapter(adapter);

        photo_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddPhotoActivity.class));
            }
        });

        listView_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(MainActivity.this, PhotoActivity.class);
                intent.putExtra("idPhoto", position);
                startActivity(intent);
            }
        });
    }
}