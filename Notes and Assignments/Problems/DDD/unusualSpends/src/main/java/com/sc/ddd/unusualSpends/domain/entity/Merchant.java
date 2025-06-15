package com.sc.ddd.unusualSpends.domain.entity;

import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import com.sc.ddd.unusualSpends.exception.InvalidCategoryException;
import com.sc.ddd.unusualSpends.exception.InvalidIdException;
import com.sc.ddd.unusualSpends.exception.InvalidNameException;

public class Merchant {
    final String id;
    private final String name;
    private final SpendingCategory category;

    public Merchant(String id, String name, SpendingCategory category) {

        if(id == null || id.isBlank())
            throw new InvalidIdException(id);
        if(name == null || name.isBlank())
            throw new InvalidNameException(name);

        isValidCategory(category.toString());

        this.id = id;
        this.name = name;
        this.category = category;
    }

    public static void isValidCategory(String category) {
        try {
            SpendingCategory.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidCategoryException(category);
        }
    }
}
