package com.hands.handsignsapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hands.handsignsapp.R;
import com.hands.handsignsapp.adapter.RecyclerAdapter;
import com.hands.handsignsapp.model.ItemList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearnFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearnFragment extends Fragment {

    private RecyclerView rvLista;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LearnFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearnFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LearnFragment newInstance(String param1, String param2) {
        LearnFragment fragment = new LearnFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_learn, container, false);
        // Inflate the layout for this fragment
        rvLista = (RecyclerView) view.findViewById(R.id.rvLista);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items);
        rvLista.setAdapter(adapter);

        return view;

    }




    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Dibuja la Cara", "Ultima pelicula de DB, peleas epicas.", R.drawable.dibujarcara));
        itemLists.add(new ItemList("Pinta el dibujo", "La ultima transformacion de la saga no canon.", R.drawable.pintardibujo));
        itemLists.add(new ItemList("Mamá", "Ultima pelicula de DB, peleas epicas.", R.drawable.mama));
        itemLists.add(new ItemList("Papá", "La ultima transformacion de la saga no canon.", R.drawable.papa));
        itemLists.add(new ItemList("Abre el libro", "Ultima pelicula de DB, peleas epicas.", R.drawable.abrelibro));


        return itemLists;
    }
    /*public void init(){
        elements= new ArrayList<>();
        elements.add(new ListElement(R.drawable.abrelibro,"Abrir Libro","azul"));
        elements.add(new ListElement(R.drawable.dibujarcara,"Dibujar Cara","azul"));
        elements.add(new ListElement(R.drawable.mama,"Mama","azul"));
        elements.add(new ListElement(R.drawable.papa,"Papa","azul"));


        ListAdapter listAdapter=new ListAdapter(elements, this);
        RecyclerView recyclerView = recyclerView.findViewById(R.id.listRecyclerView );
        recyclerView.setHasFixedSize(true);

    }*/




}