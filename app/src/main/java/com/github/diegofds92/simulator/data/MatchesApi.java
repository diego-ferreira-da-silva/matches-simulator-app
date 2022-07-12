package com.github.diegofds92.simulator.data;


import com.github.diegofds92.simulator.domain.Match;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesApi {

    @GET("matches.json")
    public Call<List<Match>> getMatches();
}
