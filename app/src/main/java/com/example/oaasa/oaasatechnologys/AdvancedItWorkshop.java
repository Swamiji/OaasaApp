package com.example.oaasa.oaasatechnologys;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdvancedItWorkshop extends Fragment {
    ListView listView;
    int image[]={R.drawable.robotics_workshop,R.drawable.embeded_system,R.drawable.cyber_security
            ,R.drawable.web_engineering,R.drawable.design_engineering,R.drawable.erp_workshop};

    String title[]={"Robotics","Embedded System","Cyber Security","Web Engineering","Design Engineering","Advanced ERP"};
    String title1[]={"Workshop","Workshop","Workshop","Workshop","Workshop","Workshop"};
    public AdvancedItWorkshop() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_advanced_it_workshop, container, false);
        listView=(ListView)view.findViewById(R.id.listView2);
        RecyclerAdapter1 recyclerAdapter=new RecyclerAdapter1(getActivity(),R.layout.horizontal_row2);
        listView.setAdapter(recyclerAdapter);
        int i=0;
        for(String Title:title){
            Adapter_Info1 adapter_info1=new Adapter_Info1(Title,title1[i],image[i]);
            recyclerAdapter.add(adapter_info1);
            i++;
        }
        return view;
    }

}
