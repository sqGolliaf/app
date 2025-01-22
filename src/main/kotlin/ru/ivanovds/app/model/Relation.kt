package ru.ivanovds.app.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Relation(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("destination_node_id")
    val destNodeId: Int,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("namespace")
    val namespace: String,
    @JsonProperty("source_node_id")
    val sourceNodeId: Int,
    @JsonProperty("attributes")
    val attributes: Attribute? = null
)