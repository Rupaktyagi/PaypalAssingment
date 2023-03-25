package com.rupak.model;

import com.rupak.enums.Status;
import com.rupak.enums.TaskType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bug.class, name = "Bug"),
        @JsonSubTypes.Type(value = Feature.class, name = "Feature"),
        @JsonSubTypes.Type(value = Story.class, name = "Story")})
public abstract class Type {
    TaskType taskType;

    public Type(TaskType taskType) {
        this.taskType = taskType;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    abstract Status nextStatus(Status taskStatus);
}
