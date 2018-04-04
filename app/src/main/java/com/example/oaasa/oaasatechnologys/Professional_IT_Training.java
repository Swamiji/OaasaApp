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
public class Professional_IT_Training extends Fragment {
    ListView listView;
    int image[] = {R.drawable.core_python, R.drawable.dijango_python, R.drawable.java_development
            , R.drawable.hadoop, R.drawable.cloude_computing, R.drawable.linux_expert};

    String title[] = {"Core", "Django", "JAVA", "Hadoop", "Cloud", "Linux"};
    String title1[] = {"Python", "Python", "Training", "Training ", "Computing", "Expert"};

    public Professional_IT_Training() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_professional__it__training, container, false);
        listView = (ListView) view.findViewById(R.id.listView12);
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
