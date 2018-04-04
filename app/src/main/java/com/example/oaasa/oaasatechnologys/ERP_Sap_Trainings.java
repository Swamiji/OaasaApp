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
public class ERP_Sap_Trainings extends Fragment {
    ListView listView;
    int image[] = {R.drawable.erp_fico, R.drawable.erp_sd, R.drawable.erp_hcm
            , R.drawable.erp_mm, R.drawable.erp_abap, R.drawable.erp_basis};

    String title[] = {"ERP", "ERP", "ERP/HR", "ERP", "ERP", "ERP"};
    String title1[] = {"FICO", "SD", "HCM", "MM", "ABAP","BASIS"};


    public ERP_Sap_Trainings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_erp__sap__trainings, container, false);
        listView = (ListView) view.findViewById(R.id.listView9);
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
