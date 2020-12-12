package com.example.tock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tock.data.Tock;
import com.example.tock.data.TockAPI;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView accountRecyclerView;

    private ArrayList<AccountData> accountData;
    private AccountAdapter accountAdapter;

    private ArrayList<CampaignData> campaignData;
    private CampaignAdapter campaignAdapter;

    private LinearLayoutManager layoutManager;
    private LinearLayoutManager layoutManager2;

    //Server url
    private final String BASE_URL = "http://";
    private TockAPI tockAPI;

    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar 설정
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);

        //account RecyclerView
        accountRecyclerView = findViewById(R.id.recycler_view_account);

        accountData = new ArrayList<>();
        accountData.add(new AccountData("122일째 진행중 \n 99,000원 투자","카페에서 \n 10% 금액을 \n 농협 예금에 투자",""));
        accountData.add(new AccountData("22일째 진행중 \n 1,000원 투자","편의점에서 \n 10% 금액을 \n 아마존에 투자",""));
        accountData.add(new AccountData("1일째 진행중 \n 0원 투자","온라인 쇼핑에서 \n 10% 금액을 \n 농협 펀드에 투자",""));
        accountAdapter = new AccountAdapter(accountData,onClickItem);

        layoutManager = new LinearLayoutManager(getBaseContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        accountRecyclerView.setLayoutManager(layoutManager);
        accountRecyclerView.setAdapter(accountAdapter);

        //campaign RecyclerView
        recyclerView = findViewById(R.id.recycler_view);

        campaignData = new ArrayList<>();
        campaignData.add(new CampaignData(R.drawable.campaign1,"배달음식 지출을 줄여 \n 북극곰 살리기 캠페인에 \n 동참해보세요"));
        campaignData.add(new CampaignData(R.drawable.campaign2,"톡톡과 함께하는 \n전국민 금연 프로젝트 \n 참여하러 갈까요?"));
        campaignAdapter = new CampaignAdapter(campaignData, onClickItem);

        layoutManager2 = new LinearLayoutManager(getBaseContext());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager2);
        recyclerView.setAdapter(campaignAdapter);


        ImageView menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivity(intent);
            }
        });
        ImageView chartButton = findViewById(R.id.chartButton);
        chartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ChartActivity.class);
                startActivity(intent);
            }
        });


        initTockAPI(BASE_URL);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private View.OnClickListener onClickItem = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            /*
                Intent intent = new Intent(this, NextActivity);
                Intent.putExtra(key, value);

                꺼내올 땐
                    Intent intent = getIntent(); // new Intent가 아닌 getIntent를 이용하여 받은 Intent 꺼내기
                    String data = intent.getString(key);
                    int data2 = intent.getIntExtra("key",0);

             */
        }
    };

    private void initTockAPI(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tockAPI = retrofit.create(TockAPI.class);
        getTock();
    }
    private void getTock(){
        Call<List<Tock>> getCall = tockAPI.getTock(userId);
        getCall.enqueue(new Callback<List<Tock>>() {
            @Override
            public void onResponse(Call<List<Tock>> call, Response<List<Tock>> response) {
                if( response.isSuccessful()){
                    List<Tock> mList = response.body();
                    String result ="";
                    for( Tock item : mList){
                        result += item.getAccount_name() + item.getAmount() + "\n";
                    }
                    //setText(resutl);
                }else {
                    Log.d("api","Status Code : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Tock>> call, Throwable t) {
                Log.d("api","Fail msg : " + t.getMessage());
            }
        });
    }

}