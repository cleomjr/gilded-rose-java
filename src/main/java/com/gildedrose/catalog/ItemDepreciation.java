package com.gildedrose.catalog;

import com.gildedrose.Item;

/**
 * Item Depreciation
 *
 * Provides different quality handling depending on the item type
 */
public interface ItemDepreciation {
    int DEFAULT_HIGHER_QUALITY_LEVEL = 50;
    int DEFAULT_LOWER_QUALITY_LEVEL = 0;

    void update(Item item);

    default void limitMinMaxQualityLevels(Item item) {
        item.quality = Math.max(item.quality, DEFAULT_LOWER_QUALITY_LEVEL);
        item.quality = Math.min(item.quality, DEFAULT_HIGHER_QUALITY_LEVEL);
    }
}
