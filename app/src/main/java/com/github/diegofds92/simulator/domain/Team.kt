package com.github.diegofds92.simulator.domain

import com.google.gson.annotations.SerializedName

data class Team(
    //@SerializedName("nome")
    val nome:String,
    //@SerializedName("forca")
    val stars:Int,
    //@SerializedName("imagem")
    val imagem:String
)
