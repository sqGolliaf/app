package ru.ivanovds.app.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Data(
    @JsonProperty("last_id")
    val lastId: Int,
    val history: List<History>,
    val namespaces: Namespace,
    val nodes: List<Node>,
    val relations: List<Relation>,
    @JsonProperty("visualize_ont_path")
    val visualizeOntPath: String
)
