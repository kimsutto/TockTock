package com.example.tock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.MyViewHolder> {

    Context context;
    List<AccountData> accountData;
    View.OnClickListener onClickItem;

    public AccountAdapter(Context context, List<AccountData> accountData, View.OnClickListener onClickItem) {
        this.context = context;
        this.accountData = accountData;
        this.onClickItem = onClickItem;
    }

    public AccountAdapter(ArrayList<AccountData> accountData, View.OnClickListener onClickItem) {
        this.accountData = accountData;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_account, parent, false);
        MyViewHolder viewHolder = new AccountAdapter.MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.account_title.setText(accountData.get(position).getAccountTitle());
        holder.account_desc.setText(accountData.get(position).getAccountDesc());
    }

    @Override
    public int getItemCount() {
        return accountData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView account_title;
        private TextView account_desc;
        private TextView account_back;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            account_title = itemView.findViewById(R.id.account_title);
            account_desc = itemView.findViewById(R.id.account_desc);
            account_back = itemView.findViewById(R.id.account_back);
        }
    }
}