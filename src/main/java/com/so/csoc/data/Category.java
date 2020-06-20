package com.so.csoc.data;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
    TV("tv"),
    BOOKS("books"),
    PHONES("phones"),
    LAPTOPS("laptops");

    Category(String category) {
        this.category = category;
    }

    @JsonValue
    public String getCategory() {
        return category;
    }

    private String category;
}
