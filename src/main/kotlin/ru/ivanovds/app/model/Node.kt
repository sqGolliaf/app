package ru.ivanovds.app.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Node(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("namespace")
    val namespace: String,
    @JsonProperty("position_x")
    val positionX: String,
    @JsonProperty("position_y")
    val positionY: String,
    @JsonProperty("attributes")
    val attributes: Attribute? = null
)