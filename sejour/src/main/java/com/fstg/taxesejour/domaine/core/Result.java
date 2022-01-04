package com.fstg.taxesejour.domaine.core;

import java.util.ArrayList;
import java.util.List;

public class Result<T,K> {
    private List<Message> errors;
    private List<Message> warnings;
    private List<Message> infos;
    private int status;
    // pour la communication entre process
    private T input; // input du premier process
    private K output; // output du premier process

    public Result(int status) {
        this.status = status;
    }

    public Result(T input, K output) {
        this.input = input;
        this.output = output;
    }

    public Result() {

    }

    public boolean hasError(){
       return getErrors().isEmpty();
    }

    public void addErrorMessage(String message) {
        addMessage(message, MessageType.ERROR);
        this.status = -1;
    }

    public void addInfoMessage(String message,int status) {
        addMessage(message, MessageType.INFO);
        this.status = status;
    }

    public void addWarningMessage(String message) {
        addMessage(message, MessageType.WARN);
        this.status = 1;
    }

    private void addMessage(String messageText, MessageType type) {
        Message message = new Message(messageText, type);
        if (type == MessageType.ERROR) {
            getErrors().add(message);
        } else if (type == MessageType.WARN) {
            getWarnings().add(message);
        } else if (type == MessageType.INFO) {
            getInfos().add(message);
        }
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public T getInput() {
        return input;
    }

    public void setInput(T input) {
        this.input = input;
    }

    public K getOutput() {
        return output;
    }

    public void setOutput(K output) {
        this.output = output;
    }

    public List<Message> getErrors() {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        return errors;
    }

    public void setErrors(List<Message> errors) {
        this.errors = errors;
    }

    public List<Message> getWarnings() {
        if (warnings == null) {
            warnings = new ArrayList<>();
        }
        return warnings;
    }

    public void setWarnings(List<Message> warnings) {
        this.warnings = warnings;
    }

    public List<Message> getInfos() {
        if (infos == null) {
            infos = new ArrayList<>();
        }
        return infos;
    }

    public void setInfos(List<Message> infos) {
        this.infos = infos;
    }

}

