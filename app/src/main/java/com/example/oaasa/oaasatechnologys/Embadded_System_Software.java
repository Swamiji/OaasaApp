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
public class Embadded_System_Software extends Fragment {
    ListView listView;
    int image[] = {R.drawable.c_programming, R.drawable.tcp_ip, R.drawable.linux_kernel
            , R.drawable.iot, R.drawable.c_plus, R.drawable.microcontroller_intel};

    String title[] = {"Practal", "TCP/IP", "Linux", "IoT on Respberyy", "C++", "Intel"};
    String title1[] = {"C", "Networking", "Internals", "PI and Arduino", "Programming", "8051"};
    public Embadded_System_Software() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_embadded__system__software, container, false);
        listView = (ListView) view.findViewById(R.id.listView8);
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
