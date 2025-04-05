package com.example.todolistkotlineduardofthiago.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todolistkotlineduardofthiago.MainActivity
import com.example.todolistkotlineduardofthiago.R
import com.example.todolistkotlineduardofthiago.data.Tarefa


class EditarTarefaActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editar_tarefa)

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]

        val saveBtn = findViewById<Button>(R.id.btnSalvarTarefa)
        val titulo = findViewById<EditText>(R.id.AlterarTitulo)
        val descricao = findViewById<EditText>(R.id.AlterarDescricao)

        saveBtn.setOnClickListener {
            val tarefa = Tarefa(tx_titulo = titulo.text.toString(), tx_descricao = descricao.text.toString())
            viewModel.createOrUpdateTarefa(tarefa = tarefa)
            finish()
        }

    }

    override fun onResume() {
        super.onResume()

    }

}