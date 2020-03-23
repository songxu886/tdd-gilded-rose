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

        assertEquals(0, items.get(1).getQuality());
        assertEquals(1, items.get(1).getSellIn());

        assertEquals(51, items.get(2).getQuality());
        assertEquals(1, items.get(2).getSellIn());
    }
}
