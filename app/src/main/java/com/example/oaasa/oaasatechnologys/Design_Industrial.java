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
public class Design_Industrial extends Fragment {
    ListView listView;
    int image[] = {R.drawable.revit_arch, R.drawable.revit_structure, R.drawable.robot_structure
            , R.drawable.pdms, R.drawable.spthreed, R.drawable.hvac};

    String title[] = {"Revit Arch.", "Revit Structure", "Robot Structrul", "PDMS", "Smart Plant", "HVAC"};
    String title1[] = {"Pro", "Pro", "Analysis Pro.", " ", "3D", " "};


    public Design_Industrial() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_design__industrial, container, false);
        listView = (ListView) view.findViewById(R.id.listView6);
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
