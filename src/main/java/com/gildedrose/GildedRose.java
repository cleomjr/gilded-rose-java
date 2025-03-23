package com.gildedrose;

import com.gildedrose.catalog.UpdateQualityService;

class GildedRose {
    /*
    * Attention:
    * Do not alter the Item class or Items property as those belong to the goblin in the corner
    * who will insta-rage and one-shot you as he doesn't believe in shared code ownership
    *
    * */
    Item[] items;
    UpdateQualityService updateQualityService;

    public GildedRose(Item[] items) {
        this.items = items;
        this.updateQualityService = new UpdateQualityService();
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityService.chooseItemType(item.name).update(item);
        }
    }
}
