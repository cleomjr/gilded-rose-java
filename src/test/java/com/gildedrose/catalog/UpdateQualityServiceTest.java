package com.gildedrose.catalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UpdateQualityServiceTest {

    @Test
    void chooseItemType_returnsStandardItemDepreciation_whenNonSpecialItemType() {
        // given
        UpdateQualityService service = new UpdateQualityService();

        // when
        ItemDepreciation supplier = service.chooseItemType("foo");

        //then
        assertTrue(supplier instanceof StandardItem);
    }

    @Test
    void chooseItemType_returnsSpecialItemDepreciation_whenSpecialItemType() {
        // given
        UpdateQualityService service = new UpdateQualityService();

        // when
        ItemDepreciation supplier = service.chooseItemType("Aged Brie");

        //then
        assertTrue(supplier instanceof AgedBrieItem);
    }
}
