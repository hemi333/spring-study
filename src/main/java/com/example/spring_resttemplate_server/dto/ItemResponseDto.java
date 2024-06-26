package com.example.spring_resttemplate_server.dto;

import com.example.spring_resttemplate_server.entity.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ItemResponseDto {
    private final List<Item> items = new ArrayList<>();

    public void setItems(Item item) {
        items.add(item);
    }
}
