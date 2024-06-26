package com.example.spring_resttemplate_server.entity;

import lombok.Getter;

@Getter
public class Item {
    private String title;
    private int price;

    public Item(String title, int price) {
        this.title = title;
        this.price = price;
    }
}