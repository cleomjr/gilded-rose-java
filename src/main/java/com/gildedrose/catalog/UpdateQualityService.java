package com.gildedrose.catalog;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class UpdateQualityService {
    private static final Map<String, Supplier<ItemDepreciation>> ITEM_TYPES;
    static {
        final Map<String, Supplier<ItemDepreciation>> itemTypes = new HashMap<>();
        itemTypes.put("Aged Brie", AgedBrieItem::new);
        itemTypes.put("Backstage passes to a TAFKAL80ETC concert", BackstagePassItem::new);
        itemTypes.put("Conjured Mana Cake", ConjuredItem::new);
        itemTypes.put("Sulfuras, Hand of Ragnaros", LegendaryItem::new);
        ITEM_TYPES = Collections.unmodifiableMap(itemTypes);
    }

    public ItemDepreciation chooseItemType(String itemName) {
        Supplier<ItemDepreciation> itemDepreciationSupplier = ITEM_TYPES.get(itemName);
        itemDepreciationSupplier = itemDepreciationSupplier == null? StandardItem::new : itemDepreciationSupplier;
        return itemDepreciationSupplier.get();
    }
}
