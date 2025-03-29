package com.example.todolistkotlineduardofthiago

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistkotlineduardofthiago.data.Tarefa
import com.example.todolistkotlineduardofthiago.view.MainViewModel
import com.example.todolistkotlineduardofthiago.view.MainViewModelFactory
import com.example.todolistkotlineduardofthiago.view.TarefaAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: TarefaAdapter
    private lateinit var recyclerView: RecyclerView

    private var originalTarefaList: List<Tarefa> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]

        recyclerView = findViewById(R.id.ListaT)

        adapter = TarefaAdapter(viewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.getAllTarefas()

        viewModel.tarefas.observe(this, Observer { tarefas ->
            originalTarefaList = tarefas
            adapter.submitList(tarefas)
        })
    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllTarefas()

        viewModel.tarefas.observe(this, Observer { tarefas ->
            adapter.submitList(tarefas)
        })
    }
}