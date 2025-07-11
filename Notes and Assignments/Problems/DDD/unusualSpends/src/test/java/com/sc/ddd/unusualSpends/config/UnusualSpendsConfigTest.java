package com.sc.ddd.unusualSpends.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnusualSpendsConfigTest {

    @Test
    void shouldCreateObjectWithGivenValue(){
        var percentage = 60;
        var unusualSpendsConfig = new UnusualSpendsConfig(percentage);

        assertEquals(percentage, unusualSpendsConfig.getPercentage());

    }

}