package com.github.diegofds92.simulator.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.diegofds92.simulator.R;
import com.github.diegofds92.simulator.data.MatchesApi;
import com.github.diegofds92.simulator.databinding.ActivityMainBinding;
import com.github.diegofds92.simulator.domain.Match;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MatchesApi matchesApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupHttpClient();
        setupMatchesList();
        //Funcionando sem o http e Matches
        setupMatchesRefresh();
        setupFloatingActionButton();
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://diegofds92.github.io/matches-simulator-api/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        matchesApi = retrofit.create(MatchesApi.class);
    }

    private void setupMatchesList(){
        matchesApi.getMatches().enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                if(response.isSuccessful()){
                    List<Match> matches = response.body();
                    Log.i("SIMULATOR", "Deu tudo certo. Partidas = " + matches.size());
                }else{
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                showErrorMessage();
            }
        });
    }



    private void setupMatchesRefresh(){
        //TODO Atualizar as partidas na ação  de swipe
    }

    private void setupFloatingActionButton(){
        //TODO criar eventos de clique e simulação de partidas
    }
    private void showErrorMessage() {
        Snackbar.make(binding.fabSimulate, R.string.error_api, Snackbar.LENGTH_LONG).show();
    }
}