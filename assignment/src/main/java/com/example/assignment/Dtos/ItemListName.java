package com.example.assignment.Dtos;

import java.util.List;

public class ItemListName {
    private List<String> names;

    public ItemListName() {
    }

    public ItemListName(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

}
