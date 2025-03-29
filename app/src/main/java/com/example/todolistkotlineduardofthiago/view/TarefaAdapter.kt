package com.example.todolistkotlineduardofthiago.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistkotlineduardofthiago.R
import com.example.todolistkotlineduardofthiago.data.Tarefa

class TarefaAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<TarefaAdapter.ViewHolder>() {
    private val tarefas = mutableListOf<Tarefa>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.visualizar_tarefa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.tarefaTextTextView.text = tarefa.tx_titulo
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, TarefaAdapter::class.java)
            intent.putExtra("tarefa_id", tarefa.id_tarefa)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }

    fun submitList(tarefas: List<Tarefa>) {
        this.tarefas.clear()
        this.tarefas.addAll(tarefas)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tarefaTextTextView: TextView = itemView.findViewById(R.id.Titulo)
    }
}