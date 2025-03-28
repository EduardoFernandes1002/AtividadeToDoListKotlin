package data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repositorio(private val TarefaDao: TarefaDao) {
    suspend fun getAllTarefas(): List<Tarefa>? = withContext(Dispatchers.IO) { TarefaDao.getAllTarefas() }
    suspend fun createOrUpdateTarefa(tarefa: Tarefa) = withContext(Dispatchers.IO) { TarefaDao.createOrUpdateTarefa(tarefa) }
    suspend fun getTarefaByTarefaId(tarefaId: Int) = withContext(Dispatchers.IO) { TarefaDao.getTarefaByTarefaId(tarefaId) }
    fun searchTarefas(query: String): List<Tarefa>? {
        return TarefaDao.searchTarefas(query)
    }
}