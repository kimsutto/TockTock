package com.example.tock;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.communication.IOnBarClickedListener;
import org.eazegraph.lib.models.BarModel;

public class ChartActivity extends AppCompatActivity {
    public ChartActivity(){
        //empty
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        mBarChart = (BarChart) findViewById(R.id.barchart);
        mBarChart2 = (BarChart) findViewById(R.id.barchart2);
        mBarChart3 = (BarChart) findViewById(R.id.barchart3);

        mBarChart.setOnBarClickedListener(new IOnBarClickedListener() {
            @Override
            public void onBarClicked(int _Position) {
                Log.d("BarChart", "Position: " + _Position);
            }
        });
        loadData();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
    private void loadData() {
        mBarChart.addBar(new BarModel("편의점",1.3f, 0xFF123456));
        mBarChart.addBar(new BarModel(1.f,  0xFF873F56));
        mBarChart.addBar(new BarModel(1.2f, 0xFF1BA4E6));

        mBarChart2.addBar(new BarModel("편의점",0.8f, 0xFF123456));
        mBarChart2.addBar(new BarModel(0.7f,  0xFF873F56));
        mBarChart2.addBar(new BarModel(1.0f, 0xFF1BA4E6));

        mBarChart3.addBar(new BarModel("편의점",0.5f, 0xFF123456));
        mBarChart3.addBar(new BarModel(0.3f,  0xFF873F56));
        mBarChart3.addBar(new BarModel(0.7f, 0xFF1BA4E6));
    }

    private BarChart mBarChart;
    private BarChart mBarChart2;
    private BarChart mBarChart3;
}
