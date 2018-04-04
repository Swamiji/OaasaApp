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
public class Cyber_Security extends Fragment {
    ListView listView;
    int image[] = {R.drawable.ethical_hacking, R.drawable.cyber_forensics, R.drawable.network_security
            , R.drawable.web_security_expert, R.drawable.reverse_engineering, R.drawable.offensive_security};

    String title[] = {"Ethical", "Cyber", "Network", "Web Security", "Reverse", "Offensive"};
    String title1[] = {"Hacking", "Forensics", "Security", "Expert", "Engineering", "Security"};



    public Cyber_Security() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_cyber__security, container, false);
        listView = (ListView) view.findViewById(R.id.listView4);
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
