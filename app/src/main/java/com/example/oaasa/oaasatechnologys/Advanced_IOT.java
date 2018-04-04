package com.example.oaasa.oaasatechnologys;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Advanced_IOT extends Fragment {
    ListView listView;
    int image[]={R.drawable.medical_iot,R.drawable.iot_bulfi,R.drawable.iot_analytics
    ,R.drawable.iot_uno,R.drawable.iot_admin,R.drawable.iot_pi};

    String title[]={"IoT Medical","IoT Bulfi","IoT Analytics","IoT Uno","IoT Admin","IoT Pi"};
    public Advanced_IOT() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_advanced__iot, container, false);
        listView=(ListView)view.findViewById(R.id.listView1);
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(getActivity(),R.layout.horizontal_row1);
        listView.setAdapter(recyclerAdapter);
        int i=0;
        for(String Title:title){
            Adapter_Info adapter_info=new Adapter_Info(Title,image[i]);
            recyclerAdapter.add(adapter_info);
            i++;
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"Position :"+position,Toast.LENGTH_SHORT).show();
                if(position==0){
                    Intent intent=new Intent(getContext(),Iot_Medical.class);
                    startActivity(intent);
                }
                else if(position==1){
                    Intent intent=new Intent(getContext(),Iot_Bulfi.class);
                    startActivity(intent);
                }
                else if(position==2){
                    Intent intent=new Intent(getContext(),Iot_Analytics.class);
                    startActivity(intent);
                }
                else if(position==3){
                    Intent intent=new Intent(getContext(),iot_uno.class);
                    startActivity(intent);
                }
                else if(position==4){
                    Intent intent=new Intent(getContext(),Iot_Admin.class);
                    startActivity(intent);
                }
                else if(position==5){
                    Intent intent=new Intent(getContext(),Iot_Pi.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

}
