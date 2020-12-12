package com.example.tock;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.iml.ActionProcessButton;
import com.example.tock.data.Tock;
import com.example.tock.data.TockAPI;
import com.example.tock.utils.ProgressGenerator;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InputActivity  extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {

    public static final String EXTRAS_ENDLESS_MODE = "EXTRAS_ENDLESS_MODE";

    //Server url
    private final String BASE_URL = "http://";
    private TockAPI tockAPI;

    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        final EditText editAccount = (EditText) findViewById(R.id.editAccount);
        final EditText editMoney = (EditText) findViewById(R.id.editMoney);

        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        final ActionProcessButton btnSignIn = (ActionProcessButton) findViewById(R.id.btnSignIn);
        Bundle extras = getIntent().getExtras();
        if(extras != null && extras.getBoolean(EXTRAS_ENDLESS_MODE)) {
            btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);
        } else {
            btnSignIn.setMode(ActionProcessButton.Mode.PROGRESS);
        }
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(btnSignIn);
                btnSignIn.setEnabled(false);
                editAccount.setEnabled(false);
                editMoney.setEnabled(false);
                initTockAPI(BASE_URL);
            }
        });
        editMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    @Override
    public void onComplete() {
        Toast.makeText(this, "성공", Toast.LENGTH_LONG).show();
    }


    private void initTockAPI(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tockAPI = retrofit.create(TockAPI.class);
        postTock();
    }
    private void postTock(){
        Tock item = new Tock();
        item.setAccount_name("d");
        //item.setCreated_time();
        Call<Tock> postCall = tockAPI.postTock(item);
        postCall.enqueue(new Callback<Tock>() {
            @Override
            public void onResponse(Call<Tock> call, Response<Tock> response) {
                if(response.isSuccessful()){
                    Log.d("postAPI","등록 완료");
                }else {
                    Log.d("postAPI","Status Code : " + response.code());
                    Log.d("postAPI",response.errorBody().toString());
                    Log.d("postAPI",call.request().body().toString());
                }
            }

            @Override
            public void onFailure(Call<Tock> call, Throwable t) {
                Log.d("postAPI","Fail msg : " + t.getMessage());
            }
        });
    }

}
