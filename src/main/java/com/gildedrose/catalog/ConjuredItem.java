package com.gildedrose.catalog;

import com.gildedrose.Item;

public class ConjuredItem implements ItemDepreciation {

    @Override
    public void update(Item item) {
        item.sellIn--;
        item.quality = item.quality - 2;

        item.quality = item.sellIn < 0? item.quality - 2 : item.quality;

        limitMinMaxQualityLevels(item);
    }
}
