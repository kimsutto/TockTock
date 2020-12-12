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

public class CampaignAdapter extends RecyclerView.Adapter<CampaignAdapter.MyViewHolder> {

    Context context;
    List<CampaignData> campaignData;
    View.OnClickListener onClickItem;

    public CampaignAdapter(Context context, List<CampaignData> campaignData, View.OnClickListener onClickItem) {
        this.context = context;
        this.campaignData = campaignData;
        this.onClickItem = onClickItem;
    }

    public CampaignAdapter(ArrayList<CampaignData> campaignData, View.OnClickListener onClickItem) {
        this.campaignData = campaignData;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.campaign_img.setImageResource(campaignData.get(position).getCampaignImg());
        holder.campaign_desc.setText(campaignData.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return campaignData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView campaign_img;
        private TextView campaign_desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            campaign_img = itemView.findViewById(R.id.campaign_img);
            campaign_desc = itemView.findViewById(R.id.campaign_desc);
        }
    }
}
