package com.example.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    private Context context;
    private ArrayList<Song> objects;
    private ImageView iv1, iv2, iv3, iv4, iv5;
    private TextView tv1, tv2, tv3;

    public SongAdapter(Context context, int resource, ArrayList<Song> songs) {
        super(context, resource, songs);
        this.context = context;
        objects = songs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);
        tv1 = rowView.findViewById(R.id.textView5);
        tv2 = rowView.findViewById(R.id.textView6);
        tv3 = rowView.findViewById(R.id.textView7);
        iv1 = rowView.findViewById(R.id.imageView2);
        iv2 = rowView.findViewById(R.id.imageView3);
        iv3 = rowView.findViewById(R.id.imageView4);
        iv4 = rowView.findViewById(R.id.imageView5);
        iv5 = rowView.findViewById(R.id.imageView6);


        //Match the UI components with Java variables

        Song song = objects.get(position);
        ImageView[] array = {iv1, iv2, iv3, iv4, iv5};
        tv1.setText(song.getYear() + "");
        tv2.setText(song.getTitle());
        tv3.setText(song.getSinger());

        //Check if the property for starts >= 5, if so, "light" up the stars
        if (song.getStars() >= 5) {
            iv5.setImageResource(android.R.drawable.star_on);
            iv4.setImageResource(android.R.drawable.star_on);
            iv3.setImageResource(android.R.drawable.star_on);
            iv2.setImageResource(android.R.drawable.star_on);
            iv1.setImageResource(android.R.drawable.star_on);
        }
        else {
            for (int i = 0; i < song.getStars(); i++) {
                array[i].setImageResource(android.R.drawable.star_on);
            }
        }

        return rowView;
    }
}
