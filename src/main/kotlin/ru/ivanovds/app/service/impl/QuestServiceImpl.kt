package ru.ivanovds.app.service.impl

import org.springframework.stereotype.Service
import ru.ivanovds.app.domain.EmployeeResponse
import ru.ivanovds.app.exception.NotFoundException
import ru.ivanovds.app.model.Node
import ru.ivanovds.app.model.Relation
import ru.ivanovds.app.repo.DataRepo
import ru.ivanovds.app.service.QuestService

@Service
class QuestServiceImpl(private val dataRepo: DataRepo): QuestService {

    override fun questById(key: String): EmployeeResponse {
        val nodes = dataRepo.getNodes()
        val relations = dataRepo.getRelations()
        return getNodeRevert(nodes, relations, key)
    }

    override fun quest(): List<EmployeeResponse> {
        val nodes = dataRepo.getNodes()
        val relations = dataRepo.getRelations()
        val nodesResult: MutableList<EmployeeResponse> = mutableListOf()
        val tmpResponse: EmployeeResponse = getNodeFirst(nodes, relations, "#Старт")
        var word = tmpResponse.questionText
        for (i in 0 .. 3) {
            val tmpResp = getNodeRevert(nodes, relations, word)
            word = tmpResp.questionText
            nodesResult.add(tmpResp)
        }
        return nodesResult
    }

    private fun getNodeRevert(nodes: List<Node>, relations: List<Relation>, name: String): EmployeeResponse {
        val node = nodes.find { it.name == name }
        val relation = relations.find { it.destNodeId == node?.id }
        val result = nodes.find { relation?.sourceNodeId == it.id } ?: throw NotFoundException("Node not found")
        return EmployeeResponse(
            id = result.id,
            questionText = result.name,
            questionType = "text"
        )
    }

    private fun getNodeFirst(nodes: List<Node>, relations: List<Relation>, name: String): EmployeeResponse {
        val node = nodes.find { it.name == name }
        val relation = relations.find { it.sourceNodeId == node?.id }
        val result = nodes.find { relation?.destNodeId == it.id } ?: throw NotFoundException("Node not found")
        return EmployeeResponse(
            id = result.id,
            questionText = result.name,
            questionType = "text"
        )
    }
}