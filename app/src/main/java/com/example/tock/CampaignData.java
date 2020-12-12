package com.example.tock;

public class CampaignData {
    private int campaignImg;
    private String desc;

    public CampaignData(int campaignImg, String desc){
        this.campaignImg = campaignImg;
        this.desc = desc;
    }

    public int getCampaignImg() {
        return campaignImg;
    }

    public void setCampaignImg(int campaignImg) {
        this.campaignImg = campaignImg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
