package com.example.todolistkotlineduardofthiago.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todolistkotlineduardofthiago.R
import com.example.todolistkotlineduardofthiago.databinding.ListarTarefaBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListarTarefaFragment : Fragment() {

    private var _binding: ListarTarefaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = ListarTarefaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddTarefa.setOnClickListener {
            findNavController().navigate(R.id.action_ListarTarefa_para_EditarTarefa)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}