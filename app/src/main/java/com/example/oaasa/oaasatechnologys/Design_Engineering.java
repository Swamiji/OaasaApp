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
public class Design_Engineering extends Fragment {
    ListView listView;
    int image[] = {R.drawable.revit_mep, R.drawable.staadpro_expert, R.drawable.autocad_master
            , R.drawable.catia, R.drawable.solid_works, R.drawable.ansys};

    String title[] = {"Revit", "Staad.Pro", "AutoCAD", "Catia", "Solid", "Ansys"};
    String title1[] = {"MEP", "Expert", "Master", " ", "Works", " "};

    public Design_Engineering() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_design__engineering, container, false);
        listView = (ListView) view.findViewById(R.id.listView5);
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
