package com.fstg.taxesejour.domaine.core;

public interface AbstractProcess<T> {
    Result execute(T abstractProcessInput);
}
