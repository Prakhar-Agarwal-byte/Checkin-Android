package com.checkin.app.checkin.Shop.ShopInvoice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.checkin.app.checkin.R;

public class ShopInvoiceAdapter extends RecyclerView.Adapter<ShopInvoiceAdapter.ShopInvoiceHolder>{

    @NonNull
    @Override
    public ShopInvoiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_shop_invoice,parent,false);
        return new ShopInvoiceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopInvoiceHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ShopInvoiceHolder extends RecyclerView.ViewHolder{
        public ShopInvoiceHolder(View itemView) {
            super(itemView);
        }
    }
}
