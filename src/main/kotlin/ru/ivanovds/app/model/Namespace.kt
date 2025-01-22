package ru.ivanovds.app.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Namespace(
    private val default: String,
    @JsonProperty("ontolis-avis")
    private val ontolisAvis: String,
    private val owl: String,
    private val rdf: String,
    private val rdfs: String,
    private val xsd: String
)
