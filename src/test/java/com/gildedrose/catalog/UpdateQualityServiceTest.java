package com.gildedrose.catalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class UpdateQualityServiceTest {

    @Test
    void chooseItemType_returnsStandardItemDepreciation_whenNonSpecialItemType() {
        // given
        UpdateQualityService service = new UpdateQualityService();

        // when
        ItemDepreciation supplier = service.chooseItemType("foo");

        //then
        assertInstanceOf(StandardItem.class, supplier);
    }

    @Test
    void chooseItemType_returnsSpecialItemDepreciation_whenSpecialItemType() {
        // given
        UpdateQualityService service = new UpdateQualityService();

        // when
        ItemDepreciation supplier = service.chooseItemType("Aged Brie");

        //then
        assertInstanceOf(AgedBrieItem.class, supplier);
    }
}
