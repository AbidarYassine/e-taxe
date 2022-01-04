package com.fstg.taxesejour.domaine.core;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractProcessImpl<T> {
    protected Map<String, Object> data = new HashMap<>();

    public Result execute(T abstractProcessInput) {
        Result result = new Result();
        init();
        if (validateProcess(abstractProcessInput, result)) {
            run(abstractProcessInput, result);
        }
        return result;
    }

    protected void init() {
       
    }

    public boolean validateProcess(T abstractProcessInput, Result result) {
        validate(abstractProcessInput, result);
        return result.hasError();
    }

    public abstract void validate(T abstractProcessInput, Result result);

    public abstract void run(T abstractProcessInput, Result result);

}
