package com.example.todolistkotlineduardofthiago.data

import androidx.room.*

@Dao
interface TarefaDao {
    @Query("SELECT * FROM tarefa")
    fun getAllTarefas(): List<Tarefa>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createOrUpdateTarefa(tarefa: Tarefa)

    @Query("SELECT * FROM tarefa WHERE tx_titulo LIKE :query")
    fun searchTarefas(query: String): List<Tarefa>?

    @Query("SELECT * FROM tarefa WHERE id_tarefa = :tarefaId")
    fun getTarefaByTarefaId(tarefaId: Int): Tarefa
}