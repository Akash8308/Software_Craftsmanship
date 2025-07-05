package com.sc.ddd.unusualSpends.domain.entity;

import com.sc.ddd.unusualSpends.domain.valueobject.SpendingCategory;
import com.sc.ddd.unusualSpends.exception.InvalidIdException;
import com.sc.ddd.unusualSpends.exception.InvalidNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MerchantTest {

    @Test
    void shouldCreateObjectWithGivenValues(){
        String merchId = "101";
        String merchName = "Akash";
        SpendingCategory spendingCategory = SpendingCategory.FOOD;

        var merch = new Merchant(merchId, merchName, spendingCategory);

        assertEquals(merchId, merch.getId() );
        assertEquals(merchName, merch.getName() );
        assertEquals(spendingCategory, merch.getCategory() );
    }

    @Test
    void shouldThrowInvalidIdExceptionWhenIdIsNull(){
        String id = null;
        String merchName = "Akash";
        SpendingCategory spendingCategory = SpendingCategory.TRAVEL;
        String expectedExceptionMessage = "Invalid ID: null";

        var exceptionObj = assertThrows(InvalidIdException.class , () -> new Merchant(id, merchName, spendingCategory));

        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
    }

    @Test
    void shouldThrowInvalidIdExceptionWhenIdIsBlank(){
        String id = "   ";
        String merchName = "Akash";
        SpendingCategory spendingCategory = SpendingCategory.TRAVEL;
        String expectedExceptionMessage = "Invalid ID: Blank";

        var exceptionObj = assertThrows(InvalidIdException.class , () -> new Merchant(id, merchName, spendingCategory));

        assertThrows(InvalidIdException.class, () -> new Merchant(id, merchName, spendingCategory));
    }

    @Test
    void shouldThrowInvalidNameExceptionWhenNameIsNull(){
        String id = "101";
        String merchName = null;
        SpendingCategory spendingCategory = SpendingCategory.TRAVEL;
        String expectedExceptionMessage = "Invalid name: null";

        var exceptionObj = assertThrows(InvalidNameException.class , () -> new Merchant(id, merchName, spendingCategory));

        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
    }

    @Test
    void shouldThrowInvalidNameExceptionWhenNameIsBlank(){
        String id = "101";
        String merchName = "              ";
        SpendingCategory spendingCategory = SpendingCategory.TRAVEL;
        String expectedExceptionMessage = "Invalid name: Blank";

        var exceptionObj = assertThrows(InvalidNameException.class , () -> new Merchant(id, merchName, spendingCategory));

        assertEquals(expectedExceptionMessage, exceptionObj.getMessage());
    }


}