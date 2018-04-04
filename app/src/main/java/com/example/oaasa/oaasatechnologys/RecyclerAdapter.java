package com.example.oaasa.oaasatechnologys;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Amit on 7/11/2017.
 */

public class RecyclerAdapter extends ArrayAdapter {
    private List list=new ArrayList();

    public RecyclerAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    public void add( Adapter_Info object) {
        super.add(object);
        list.add(object);
    }

    @Nullable
    @Override
    public Object getItem(int position) {
         return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder=new ViewHolder();
        if(convertView==null){
            LayoutInflater layoutInflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.horizontal_row1,parent,false);
            viewHolder.circleImageView=(CircleImageView) convertView.findViewById(R.id.circleImageview1);
            viewHolder.textView=(TextView)convertView.findViewById(R.id.iot_medical_title);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
       Adapter_Info info=(Adapter_Info) getItem(position);
        viewHolder.textView.setText(info.getName());
        viewHolder.circleImageView.setImageResource(info.getImage());
        return convertView;
    }
    static class ViewHolder{
        //ImageView imageView;
        CircleImageView circleImageView;
        TextView textView;
    }
}

