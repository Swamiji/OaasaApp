package com.example.oaasa.oaasatechnologys;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Amit on 7/11/2017.
 */

public class RecyclerAdapter1 extends ArrayAdapter {
    private List list=new ArrayList();

    public RecyclerAdapter1(@NonNull Context context, int resource) {
        super(context, resource);
    }
    public void add( Adapter_Info1 object) {
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
            convertView=layoutInflater.inflate(R.layout.horizontal_row2,parent,false);
            viewHolder.circleImageView=(CircleImageView) convertView.findViewById(R.id.circleImageview);
            viewHolder.textView1=(TextView)convertView.findViewById(R.id.advanced_it_title);
            viewHolder.textView2=(TextView)convertView.findViewById(R.id.advanced_it_title1);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
       Adapter_Info1 info1=(Adapter_Info1) getItem(position);
        viewHolder.textView1.setText(info1.getTitle());
        viewHolder.textView2.setText(info1.getTitle1());
        viewHolder.circleImageView.setImageResource(info1.getImage());
        return convertView;
    }
    static class ViewHolder{
        //ImageView imageView;
        CircleImageView circleImageView;
        TextView textView1,textView2;
    }
}

