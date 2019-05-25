package com.example.marvel.marvel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        setUI();
        mainActivityController = new MainActivityController(this);
        mainActivityController.callAPI();
    }

    private void setUI() {
        recyclerViewCharacter = (RecyclerView) findViewById(R.id.list_character);
    }

    public void populationScreen() {
        //progress.dismiss();
        

        layoutRV = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewCharacter.setLayoutManager(layoutRV);

        statementAdapter = new StatementAdapter(listCharacter);
        recyclerViewCharacter.setAdapter(statementAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dismissProgress(List<ResultsCharacter> listCharacter) {
        this.listCharacter = listCharacter;
        populationScreen();
    }

    public void register() {
        EventBus.getDefault().register(this);
    }

    public void Unregister() {
        EventBus.getDefault().unregister(this);
    }

}
