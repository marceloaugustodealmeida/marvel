package com.example.marvel.marvel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.marvel.marvel.interfaceService.CharacterService;
import com.example.marvel.marvel.model.RequestCharacter;
import com.example.marvel.marvel.model.ResponseCharacter;
import com.example.marvel.marvel.util.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
        callAPI();
    }

    private void setUI() {
        listCharacter = (RecyclerView) findViewById(R.id.list_character);
    }

    private void callAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CharacterService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CharacterService service = retrofit.create(CharacterService.class);

        RequestCharacter requestLogin = new RequestCharacter();
        requestLogin.limit = "10";

        Call<ResponseCharacter> requestCatalog = service.listCharacter();

        requestCatalog.enqueue(new Callback<ResponseCharacter>() {
            @Override
            public void onResponse(Call<ResponseCharacter> call, Response<ResponseCharacter> response) {
                //progress.dismiss();
                if (!response.isSuccess()) {
                    Toast.makeText(MainActivity.this, getString(R.string.app_name) + response.code(), Toast.LENGTH_SHORT).show();

                } else {
                    ResponseCharacter dateClient = response.body();

                    //SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.userAccount), Context.MODE_PRIVATE);
                    //SharedPreferences.Editor editor = sharedPreferences.edit();

//                    editor.putInt(getString(R.string.userId), dateClient.userAccount.userId);
//                    editor.putString(getString(R.string.name), dateClient.userAccount.name);
//                    editor.putString(getString(R.string.bankAccount), dateClient.userAccount.bankAccount);
//                    editor.putString(getString(R.string.agency), dateClient.userAccount.agency);
//                    editor.putFloat(getString(R.string.balance), dateClient.userAccount.balance);

                    //editor.putString(getString(R.string.user), edtUser.getText().toString());

                    //editor.apply();
                    //Intent intent = new Intent(LoginActivity.this, DetailsActivity.class);
                    //startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<ResponseCharacter> call, Throwable t) {
                if (!Utils.isConected(MainActivity.this)) {
                    Toast.makeText(MainActivity.this, getString(R.string.notConnectInternet), Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this, getString(R.string.fail) + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
