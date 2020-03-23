package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    GildedRose gildedRose;

    @BeforeEach
    public void setUp() {
        gildedRose = new GildedRoseImpl();
    }
    @Test
    public void testUpdateQualityOfAgedBrie() {
        // Given
        List<Product> items = Stream
                .of(new Product("Aged Brie", 2, 0),
                        new Product("Aged Brie", 2, -1),
                        new Product("Aged Brie", 2, 51))
                .collect(Collectors.toList());

        // When
        gildedRose.updateQuality(items);

        // Then
        assertEquals(1, items.get(0).getQuality());
        assertEquals(1, items.get(0).getSellIn());

        assertEquals(-1, items.get(1).getQuality());
        assertEquals(2, items.get(1).getSellIn());

        assertEquals(51, items.get(2).getQuality());
        assertEquals(2, items.get(2).getSellIn());
    }

    @Test
    public void testUpdateQualityOfSulfuras() {
        // Given
        List<Product> items = Stream
                .of(new Product("Sulfuras", 2, 0),
                        new Product("Sulfuras", 2, -1),
                        new Product("Sulfuras", 2, 51))
                .collect(Collectors.toList());

        // When
        gildedRose.updateQuality(items);

        // Then
        assertEquals(0, items.get(0).getQuality());
        assertEquals(2, items.get(0).getSellIn());

        assertEquals(-1, items.get(1).getQuality());
        assertEquals(2, items.get(1).getSellIn());

        assertEquals(51, items.get(2).getQuality());
        assertEquals(2, items.get(2).getSellIn());
    }

    @Test
    public void testUpdateQualityOfBackstagePass() {
        // Given
        List<Product> items = Stream
                .of(new Product("Backstage pass", 10, 5),
                        new Product("Backstage pass", 5, 5),
                        new Product("Backstage pass", 11, -1),
                        new Product("Backstage pass", 2, 51),
                        new Product("Backstage pass", 11, 3),
                        new Product("Backstage pass", 1, 35))
                .collect(Collectors.toList());

        // When
        gildedRose.updateQuality(items);

        // Then
        assertEquals(7, items.get(0).getQuality());
        assertEquals(9, items.get(0).getSellIn());

        assertEquals(8, items.get(1).getQuality());
        assertEquals(4, items.get(1).getSellIn());

        assertEquals(-1, items.get(2).getQuality());
        assertEquals(11, items.get(2).getSellIn());

        assertEquals(51, items.get(3).getQuality());
        assertEquals(2, items.get(3).getSellIn());

        assertEquals(4, items.get(4).getQuality());
        assertEquals(10, items.get(4).getSellIn());

        assertEquals(0, items.get(5).getQuality());
        assertEquals(0, items.get(5).getSellIn());
    }
}
