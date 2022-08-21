package org.launchcode.techjobs.oo;

import java.util.Objects;

public class JobField {
    // Instance variables
    private int id;
    private static int nextId = 1;
    private String value;

    // Constructors
    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    // Methods
    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField that = (JobField) o;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return this.id;
    }
}
