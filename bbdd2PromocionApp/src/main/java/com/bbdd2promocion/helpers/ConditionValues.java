package com.bbdd2promocion.helpers;

import com.bbdd2promocion.repository.jpa.projections.ValueCount;

public class ConditionValues {
    private String condition;

    private Object value;

    private int count;

    public ConditionValues(String condition, ValueCount valueCount) {
        this.condition = condition;
        this.value = valueCount.getValue();
        this.count = valueCount.getCount();
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
