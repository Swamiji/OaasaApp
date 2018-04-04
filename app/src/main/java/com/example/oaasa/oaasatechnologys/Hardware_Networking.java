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
public class Hardware_Networking extends Fragment {
    ListView listView;
    int image[] = {R.drawable.ccna, R.drawable.network_plus, R.drawable.computer_hardware
            , R.drawable.mobile_repairing, R.drawable.laptop_repairing, R.drawable.chip_level};

    String title[] = {"CCNA", "Network", "Hardware", "Mobile", "Laptop", "Chip Level"};
    String title1[] = {" ", "Plus", "Engineering", "Repairing", "Repairing", "Repairing"};

    public Hardware_Networking() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_hardware__networking, container, false);
        listView = (ListView) view.findViewById(R.id.listView10);
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
