package com.gildedrose.catalog;

import com.gildedrose.Item;

public class BackstagePassItem implements ItemDepreciation {

    @Override
    public void update(Item item) {
        item.sellIn--;
        item.quality++;

        item.quality = item.sellIn <= 10? item.quality + 1 : item.quality;
        item.quality = item.sellIn <= 5? item.quality + 1 : item.quality;
        item.quality = item.sellIn < 0? 0 : item.quality;

        limitMinMaxQualityLevels(item);
    }
}
