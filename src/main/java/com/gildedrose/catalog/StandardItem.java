package com.gildedrose.catalog;

import com.gildedrose.Item;

public class StandardItem implements ItemDepreciation{

    @Override
    public void update(Item item) {
        item.sellIn--;
        item.quality = item.sellIn < 0? item.quality-2 : item.quality-1;

        limitMinMaxQualityLevels(item);
    }
}
