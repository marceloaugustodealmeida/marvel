package com.example.marvel.marvel;

import android.content.Context;
import android.widget.Toast;

import com.example.marvel.marvel.interfaceService.CharacterService;
import com.example.marvel.marvel.model.RequestCharacter;
import com.example.marvel.marvel.model.ResponseCharacter;
import com.example.marvel.marvel.model.ResultsCharacter;
import com.example.marvel.marvel.util.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivityController {

    private Context context;
    private List<ResultsCharacter> listCharacter;

    public MainActivityController(Context context) {
        this.context = context;
        this.listCharacter = new ArrayList<ResultsCharacter>();
    }

    public void callAPI(int qtdCharacter) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CharacterService.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        CharacterService service = retrofit.create(CharacterService.class);

        RequestCharacter requestLogin = new RequestCharacter();
        requestLogin.limit = "1";

        Call<ResponseCharacter> requestCatalog = service.listCharacter(qtdCharacter);

        requestCatalog.enqueue(new Callback<ResponseCharacter>() {
            @Override
            public void onResponse(Call<ResponseCharacter> call, Response<ResponseCharacter> response) {
                //progress.dismiss();
                if (!response.isSuccessful()) {
                    Toast.makeText(context, context.getString(R.string.app_name) + response.code(), Toast.LENGTH_SHORT).show();

                } else {
                    List<ResultsCharacter> listCharacter = new ArrayList<ResultsCharacter>();

                    ResponseCharacter dateClient = response.body();
                    listCharacter = dateClient.data.results;
                    EventBus.getDefault().register(context);
                    EventBus.getDefault().post(listCharacter);
                    EventBus.getDefault().unregister(context);
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
                if (!Utils.isConected(context)) {
                    Toast.makeText(context, context.getString(R.string.notConnectInternet), Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(context, context.getString(R.string.fail) + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
