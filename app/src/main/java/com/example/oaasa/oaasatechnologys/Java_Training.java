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
public class Java_Training extends Fragment {
    ListView listView;
    int image[] = {R.drawable.core_java, R.drawable.java_script, R.drawable.j_query
            , R.drawable.node_js, R.drawable.advance_java, R.drawable.angular_js};

    String title[] = {"Core", "Java", "J", "Node.", "Advance", "Angular"};
    String title1[] = {"Java", "Script", "Query", "JS", "Java", "JS"};


    public Java_Training() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_java__training, container, false);
        listView = (ListView) view.findViewById(R.id.listView11);
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
