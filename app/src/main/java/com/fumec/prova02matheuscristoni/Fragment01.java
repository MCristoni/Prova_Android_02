package com.fumec.prova02matheuscristoni;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Fragment01 extends Fragment {
    public static Fragment01 newInstance() {
        Bundle args = new Bundle();
        Fragment01 fragment = new Fragment01();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final String[] palavras = {"Essas", "São", "as", "palavras", "escolhidas", "para", "o app", "da prova", "do Laper"};
        final ListView lista = view.findViewById(R.id.lista);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, palavras);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Intent intent = new Intent(getContext(), AuxActivity.class);
                    intent.putExtra("item", palavras[position]);
                    startActivity(intent);
                }else{
                    FragmentManager manager = ((MainActivity)getActivity()).getManager();
                    Fragment02 frag2 = Fragment02.newInstance(palavras[position]);
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frame2, frag2);
                    transaction.commit();
                }
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    FragmentManager manager = ((MainActivity)getActivity()).getManager();
                    Fragment02 frag2 = Fragment02.newInstance("");
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frame2, frag2);
                    transaction.commit();
                }
                return true;
            }
        });
    }
}
