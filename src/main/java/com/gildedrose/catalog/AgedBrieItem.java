package com.gildedrose.catalog;

import com.gildedrose.Item;

public class AgedBrieItem implements ItemDepreciation {

    @Override
    public void update(Item item) {
        item.sellIn--;
        item.quality++;

        limitMinMaxQualityLevels(item);
    }
}
