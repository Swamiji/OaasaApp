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
public class web_android_technology extends Fragment {
    ListView listView;
    int image[] = {R.drawable.web_development_training, R.drawable.android_development_training, R.drawable.search_engine_optimization
            , R.drawable.google_adwards, R.drawable.social_media_marketing, R.drawable.digital_marketing};

    String title[] = {"Advance Web", "Android", "Search Engine", "Google Adwords", "Social Media", "Digital"};
    String title1[] = {"Engineering", "Development", "Optimization", "PPC", "Marketing", "Marketing"};

    public web_android_technology() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_web_android_technology, container, false);
        listView = (ListView) view.findViewById(R.id.listView13);
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
