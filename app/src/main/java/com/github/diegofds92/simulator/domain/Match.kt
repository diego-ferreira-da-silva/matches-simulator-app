package com.github.diegofds92.simulator.domain

import com.google.gson.annotations.SerializedName

data class Match (
    @SerializedName("descricao")
    val description:String,
    @SerializedName("local")
    val place: String,
    //@SerializedName("mandante")
    val homeTeam: Team,
    //@SerializedName("visitante")
    val awayTeam: Team
)