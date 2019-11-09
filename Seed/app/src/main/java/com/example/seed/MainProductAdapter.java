package com.example.seed;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seed.data.MainProductData;

import java.util.ArrayList;

// Customized by SY

public class MainProductAdapter extends RecyclerView.Adapter<MainProductAdapter.MainProductViewHolder> {

    ArrayList<MainProductData> items;

    public MainProductAdapter(ArrayList<MainProductData> items) {
        this.items = items;
    }

    @Override
    public MainProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.rv_item_main_products, viewGroup, false);
        return new MainProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainProductViewHolder viewHolder, int position) {
        MainProductData item = items.get(position);
        viewHolder.productImage.setImageResource(item.getImage());
        viewHolder.productName.setText(item.getName());
        viewHolder.productQuantity.setText(String.valueOf(item.getQuantity()));
        viewHolder.productOriginPrice.setText(String.valueOf(item.getOriginPrice()));
        viewHolder.productSalePrice.setText(String.valueOf(item.getSalePrice()));
        viewHolder.productDiscount.setText(String.valueOf(item.getDiscount()));
        viewHolder.productPlace.setText(item.getPlace());
    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        return items.size();
    }

    public void addItem(MainProductData item){
        items.add(item);
    }

    public void setItems(ArrayList<MainProductData> items){
        this.items = items;
    }

    public MainProductData getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, MainProductData item){
        items.set(position, item);
    }

    static class MainProductViewHolder extends RecyclerView.ViewHolder {
        protected ImageView productImage;
        protected TextView productName;
        protected TextView productQuantity;
        protected TextView productOriginPrice;
        protected TextView productSalePrice;
        protected TextView productDiscount;
        protected TextView productPlace;

        public MainProductViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.rv_item_main_products_image);
            productName = itemView.findViewById(R.id.rv_item_main_products_name);
            productQuantity = itemView.findViewById(R.id.rv_item_main_products_quantity);
            productOriginPrice = itemView.findViewById(R.id.rv_item_main_products_price_origin);
            productSalePrice = itemView.findViewById(R.id.rv_item_main_products_price_sale);
            productDiscount = itemView.findViewById(R.id.rv_item_main_products_discount);
            productPlace = itemView.findViewById(R.id.rv_item_main_products_place);
        }
    }

}
