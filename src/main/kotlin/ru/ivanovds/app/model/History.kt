package ru.ivanovds.app.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp
import java.time.ZonedDateTime
import javax.print.attribute.standard.Destination

data class History(
    val author: String,
    @JsonProperty("datetime")
    val dateTime: ZonedDateTime,
    @JsonIgnore
    val name: String? = null,
    @JsonIgnore
    val namespace: String? = null,
    @JsonProperty("destination_id")
    @JsonIgnore
    val destinationId: Int? = null,
    @JsonProperty("new_name")
    @JsonIgnore
    val newName: String? = null,
    @JsonProperty("new_namespace")
    @JsonIgnore
    val newNamespace: String? = null,
    @JsonProperty("node_id")
    val nodeId: Int,
    @JsonProperty("old_name")
    @JsonIgnore
    val oldName: String? = null,
    @JsonProperty("old_namespace")
    @JsonIgnore
    val oldNamespace: String? = null,
    val operation: String,
    @JsonProperty("operation_type")
    val operationType: String,
    @JsonProperty("relation_id")
    @JsonIgnore
    val relationId: Int? = null,
    @JsonProperty("source_id")
    @JsonIgnore
    val sourceId: Int? = null,
    val timestamp: Timestamp
)
