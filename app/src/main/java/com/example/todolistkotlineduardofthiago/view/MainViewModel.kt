package com.example.todolistkotlineduardofthiago.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todolistkotlineduardofthiago.data.AppDatabase
import com.example.todolistkotlineduardofthiago.data.Tarefa
import com.example.todolistkotlineduardofthiago.data.Repositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _tarefas = MutableLiveData<List<Tarefa>>()
    val tarefas: LiveData<List<Tarefa>> get() = _tarefas

    private var tarefaRepository: Repositorio

    init {
        val database = AppDatabase.getInstance(application)
        val tarefaDao = database.TarefaDao()
        tarefaRepository = Repositorio(tarefaDao)
    }

    fun createOrUpdateTarefa(tarefa: Tarefa) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                tarefaRepository.createOrUpdateTarefa(tarefa)
            } catch (_: Exception) {
            }
        }
    }

    fun getTarefaByTarefaId(tarefaId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val card = tarefaRepository.getTarefaByTarefaId(tarefaId)
                _tarefas.postValue(listOf(card))
            } catch (_: Exception) {
            }
        }
    }

    fun getAllTarefas() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val tarefas = tarefaRepository.getAllTarefas()
                _tarefas.postValue(tarefas ?: listOf())

            } catch (_: Exception) {
            }
        }
    }

}