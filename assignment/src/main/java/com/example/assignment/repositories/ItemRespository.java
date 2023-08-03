package com.example.assignment.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.assignment.Dtos.Item;
import com.example.assignment.Dtos.ItemPrice;

@Component
public class ItemRespository {

    public List<Item> getAll() {
        return new ArrayList<>() {
            {
                add(new Item(0, new ItemPrice("10", "EUR"), "item1", "Example Item", "12341234"));
                add(new Item(0, new ItemPrice("20", "EUR"), "item2", "Example Item", "12341235"));
                add(new Item(0, new ItemPrice("25", "EUR"), "item3", "Example Item", "12341236"));
            }

        };
    }

    public Item findItemByName(String name) {
        List<Item> items = getAll();
        Item selectedItem = items.stream().filter((item) -> item.getName().equalsIgnoreCase(name)).findFirst().get();

        return selectedItem;
    }
}
