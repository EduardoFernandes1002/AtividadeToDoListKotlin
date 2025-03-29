package com.example.todolistkotlineduardofthiago.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tarefa(
    @PrimaryKey(autoGenerate = true)
    var id_tarefa: Int = 0,
    var tx_titulo: String,
    var tx_descricao: String,
    var bl_checkbox: Boolean)