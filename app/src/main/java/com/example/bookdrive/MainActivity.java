package com.example.bookdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btLogin,btSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkConnection();

        btLogin=(Button) findViewById(R.id.btmainlogin);
        btSignup=(Button) findViewById(R.id.btmainsignup);

        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signup();
            }
        });
    }

    public void checkConnection(){
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        if(null==activeNetwork){
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }
    }

    private void Login(){


        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        if(null!=activeNetwork) {
            Intent in = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(in);

        }
        else{
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }


    }
    private void Signup(){
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        if(null!=activeNetwork) {
            Intent in = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(in);
        }
        else{
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }
    }
}