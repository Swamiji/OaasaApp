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
public class Automation_Robotics extends Fragment {
    ListView listView;
    int image[] = {R.drawable.robotics_engineering, R.drawable.matblab_simulink, R.drawable.embedded_system
            , R.drawable.vlsi_design, R.drawable.industrial_automation, R.drawable.artificial_intelligence};

    String title[] = {"Robotics", "MATLAB", "Embadded", "VLSI", "Industrial", "Artificial"};
    String title1[] = {"Engineering", "& SIMULINK", "System", "Design", "Automation", "Intelligence"};

    public Automation_Robotics() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_automation__robotics, container, false);
        listView = (ListView) view.findViewById(R.id.listView3);
        RecyclerAdapter1 recyclerAdapter = new RecyclerAdapter1(getActivity(), R.layout.horizontal_row2);
        listView.setAdapter(recyclerAdapter);
        int i = 0;
        for (String Title : title) {
            Adapter_Info1 adapter_info1 = new Adapter_Info1(Title, title1[i], image[i]);
            recyclerAdapter.add(adapter_info1);
            i++;
        }
        return view;
    }
}
