package ru.ivanovds.app.repo

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.ivanovds.app.model.Data
import ru.ivanovds.app.model.Node
import ru.ivanovds.app.model.Relation
import java.io.File
import java.io.IOException

@Component
class DataRepo(
    @Value("\${file.url:src/main/resources/data.json}")
    private val fileUrl: String
) {
    private val file = File(fileUrl).readText(Charsets.UTF_8)
    private val mapper = jacksonObjectMapper().registerKotlinModule().registerModule(JavaTimeModule())
    private val data = mapper.readValue<Data>(file)

    @Throws(IOException::class)
    fun getNodes(): List<Node> = data.nodes

    @Throws(IOException::class)
    fun getRelations(): List<Relation> = data.relations
}