package com.example.marvel.marvel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.marvel.marvel.adapter.EndlessRecyclerOnScrollListener;
import com.example.marvel.marvel.adapter.StatementAdapter;
import com.example.marvel.marvel.model.ResultsCharacter;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCharacter;
    private MainActivityController mainActivityController;
    private List<ResultsCharacter> listCharacter;
    private RecyclerView.LayoutManager layoutRV;
    private StatementAdapter statementAdapter;
    private ProgressBar itemProgressBar;
    private int qtdCharacter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        setUI();

        mainActivityController = new MainActivityController(this);
        mainActivityController.callAPI(qtdCharacter);
    }

    private void setUI() {
        recyclerViewCharacter = (RecyclerView) findViewById(R.id.list_character);
        itemProgressBar = (ProgressBar) findViewById(R.id.item_progress_bar);
    }

    public void populationScreen() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewCharacter.setLayoutManager(linearLayoutManager);

        statementAdapter = new StatementAdapter(listCharacter);

        recyclerViewCharacter.setAdapter(statementAdapter);

        recyclerViewCharacter.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                addDataToList();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dismissProgress(List<ResultsCharacter> listCharacter) {
        this.listCharacter = listCharacter;
        statementAdapter.notifyDataSetChanged();
        populationScreen();
    }

    public void register() {
        EventBus.getDefault().register(this);
    }

    public void Unregister() {
        EventBus.getDefault().unregister(this);
    }

    private void addDataToList() {
        //itemProgressBar.setVisibility(View.VISIBLE);

        mainActivityController.callAPI(qtdCharacter+= 5);
        //statementAdapter.notifyDataSetChanged();
        //itemProgressBar.setVisibility(View.GONE);


    }

}
