package com.hands.handsignsapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hands.handsignsapp.R;
import com.hands.handsignsapp.model.ItemList;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

    private List<ItemList> items;
    private List<ItemList> itemsOriginal;

    public RecyclerAdapter(List<ItemList> items) {
        this.items = items;
        itemsOriginal = new ArrayList<>();
        itemsOriginal.addAll(items);
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent, false);

        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        ItemList item = items.get(position);
        holder.imgItem.setImageResource(item.getImgResource());
        holder.tvTitulo.setText(item.getTitulo());


    }

    public void filtrado(String txtBuscar){
        int longitud =txtBuscar.length();
        if(longitud==0){
            items.clear();
            items.addAll(itemsOriginal);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<ItemList> colleccion = items.stream().
                        filter(i -> i.getTitulo().
                                toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                items.clear();
                items.addAll(colleccion);
            } else{
                for (ItemList i: itemsOriginal) {
                    if(i.getTitulo().toLowerCase().contains(txtBuscar.toLowerCase())){
                        items.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder {
        private ImageView imgItem;
        private TextView tvTitulo;


        public RecyclerHolder(@NonNull View itemView_1) {
            super(itemView_1);

            imgItem = itemView.findViewById(R.id.imgItem);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);

        }
    }
}