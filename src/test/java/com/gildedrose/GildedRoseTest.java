package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void foo() {
        // given
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        // when
        app.updateQuality();

        // then
        assertEquals("foo", app.items[0].name);
    }

    @Nested
    class Requirements {

        @Test
        void updateQuality_sellInAndQualityDegradesBy1() {
            // given
            GildedRose app = new GildedRose(new Item[] { new Item("foo", 1, 2) });

            // when
            app.updateQuality();

            // then
            assertEquals(0, app.items[0].sellIn);
            assertEquals(1, app.items[0].quality);
        }

        @Test
        void updateQuality_qualityDegradesTwice_whenAfterDate() {
            // given
            GildedRose app = new GildedRose(new Item[] { new Item("foo", 0, 2) });

            // when
            app.updateQuality();

            // then
            assertEquals(-1, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void updateQuality_qualityNeverNegative() {
            // given
            GildedRose app = new GildedRose(new Item[] { new Item("foo", 2, 0) });

            // when
            app.updateQuality();

            // then
            assertEquals(1, app.items[0].sellIn);
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void updateQuality_increasesBrieQuality() {
            // given
            GildedRose app = new GildedRose(new Item[] { new Item("Aged Brie", 20, 10) });

            // when
            app.updateQuality();

            // then
            assertEquals(11, app.items[0].quality);
        }

        @Test
        void updateQuality_returnsBrieMaxQuality() {
            // given
            GildedRose app = new GildedRose(new Item[] { new Item("Aged Brie", 20, 50) });

            // when
            app.updateQuality();

            // then
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void updateQuality_returnsMaxQuality() {
            // given
            GildedRose app = new GildedRose(new Item[] { new Item("foo", 30, 80) });

            // when
            app.updateQuality();

            // then
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void updateQuality_returnsLegendaryQualityAndDateNeverChange_whenLegendary() {
            // given
            Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 30, -80) };
            GildedRose app = new GildedRose(items);

            // when
            app.updateQuality();

            // then
            assertTrue(app.items[0].sellIn > 0);
            assertEquals(80, app.items[0].quality);
        }

        @Test
        void updateQuality_passQualityIncreases_whenMoreThan10() {
            // given
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 0) };
            GildedRose app = new GildedRose(items);

            // when
            app.updateQuality();

            // then
            assertEquals(1, app.items[0].quality);
        }

        @Test
        void updateQuality_passQualityIncreasesTwice_whenLessThan10() {
            // given
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
            GildedRose app = new GildedRose(items);

            // when
            app.updateQuality();

            // then
            assertEquals(2, app.items[0].quality);
        }

        @Test
        void updateQuality_passQualityIncreasesTrice_whenLessThan5() {
            // given
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0) };
            GildedRose app = new GildedRose(items);

            // when
            app.updateQuality();

            // then
            assertEquals(3, app.items[0].quality);
        }

        @Test
        void updateQuality_passQualityIsZero_whenAfterConcert() {
            // given
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
            GildedRose app = new GildedRose(items);

            // when
            app.updateQuality();

            // then
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void updateQuality_conjuredQualityDegradesTwice_whenBeforeDate() {
            // given
            Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 10) };
            GildedRose app = new GildedRose(items);

            // when
            app.updateQuality();

            // then
            assertEquals(8, app.items[0].quality);
        }

        @Test
        void updateQuality_conjuredQualityDegrades4Times_whenAfterDate() {
            // given
            Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 10) };
            GildedRose app = new GildedRose(items);

            // when
            app.updateQuality();

            // then
            assertEquals(6, app.items[0].quality);
        }
    }

}
