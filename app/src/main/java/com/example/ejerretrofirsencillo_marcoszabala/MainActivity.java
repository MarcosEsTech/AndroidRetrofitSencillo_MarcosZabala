package com.example.ejerretrofirsencillo_marcoszabala;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    IpService mService;
    Button btn;
    TextView tvIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mService = Common.getIpService();

        btn = findViewById( R.id.Button );
        tvIp = findViewById( R.id.Text );

        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIpAdress();
            }
        } );
    }

    public void getIpAdress(){
        mService.getIp().enqueue( new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                tvIp.setText( response.body().getIp() );
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        } );
    }
}
