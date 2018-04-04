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
public class Embadded_System extends Fragment {
    ListView listView;
    int image[] = {R.drawable.avr_orange, R.drawable.avr_blue, R.drawable.arduino
            , R.drawable.eight_orange, R.drawable.eight_blue, R.drawable.arm_rtos};

    String title[] = {"AVR", "AVR", "Arduino", "8051", "8051", "ARM"};
    String title1[] = {"Orange", "Blue", " ", "Orange", "Blue", "RTOS"};



    public Embadded_System() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_embadded__system, container, false);
        listView = (ListView) view.findViewById(R.id.listView7);
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
