package com.gildedrose.catalog;

import com.gildedrose.Item;

public class LegendaryItem implements ItemDepreciation {
    static final int LEGENDARY_ITEM_QUALITY_LEVEL = 80;

    @Override
    public void update(Item item) {
        item.sellIn = Integer.MAX_VALUE;
        item.quality = LEGENDARY_ITEM_QUALITY_LEVEL;
    }
}
