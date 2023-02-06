package com.example.ps3_multimedia;
import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends ArrayAdapter<String> {

    private final Activity Thiscontext;
    private final List<String> Thistitle;
    private final List<String> Thissubtitle;
    private final List<Uri> Thisimgid;

    public Adapter(Activity this_context, List<String> this_title, List<String> this_subtitle, List<Uri> this_imgid) {
        super(this_context, R.layout.activity_list_photo, this_title);
        // TODO Auto-generated constructor stub

        this.Thiscontext =this_context;
        this.Thistitle =this_title;
        this.Thissubtitle =this_subtitle;
        this.Thisimgid =this_imgid;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater= Thiscontext.getLayoutInflater();
        View row=inflater.inflate(R.layout.activity_list_photo, null,true);
        TextView title = (TextView) row.findViewById(R.id.title);
        ImageView imageView = (ImageView) row.findViewById(R.id.icon);
        TextView subtitle = (TextView) row.findViewById(R.id.subtitle);
        title.setText(Thistitle.get(position));
        imageView.setImageURI(Thisimgid.get(position));
        subtitle.setText(this.Thissubtitle.get(position));
        return row;
    };
}
