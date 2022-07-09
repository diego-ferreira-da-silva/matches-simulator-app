package com.github.diegofds92.simulator.domain

data class Match (
    val description:String,
    val place: String,
    val homeTeam: Team,
    val awayTeam: Team
)