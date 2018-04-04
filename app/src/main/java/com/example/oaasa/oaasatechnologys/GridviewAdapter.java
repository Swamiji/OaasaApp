package com.example.oaasa.oaasatechnologys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Amit on 7/11/2017.
 */

public class GridviewAdapter extends BaseAdapter {
    private int icons[];
    private String title[];
    private LayoutInflater layoutInflater;
    private Context context;

    public GridviewAdapter(int icons[],String title[],Context context){
       this.icons=icons;
       this.title=title;
       this.context=context;
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int position) {
      return icons[position];
    }

    @Override
    public long getItemId(int position) {
          return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(convertView==null){
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.row,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.image_view);
            TextView textView=(TextView)view.findViewById(R.id.text_title);
            imageView.setImageResource(icons[position]);
            //imageView.setLayoutParams(new GridView.LayoutParams(160,160));
            imageView.setPadding(3,3,3,3);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            textView.setText(title[position]);
        }
        return view;
    }
}
