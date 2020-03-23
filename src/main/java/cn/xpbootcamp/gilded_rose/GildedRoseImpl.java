package cn.xpbootcamp.gilded_rose;

import java.util.List;

public class GildedRoseImpl implements GildedRose {
    @Override
    public void updateQuality(List<Product> products) {
        products.stream().forEach(product -> {
            if (product.getQuality() < 0 || product.getQuality() > 50) {
                return;
            }
            switch (product.getName()) {
                case "Aged Brie":
                    increaseQuality(product);
                case "Sulfuras":
                    break;
                case "Backstage pass":
                    increaseBackstagePassQuality(product);
            }

            if (!product.getName().equals("Sulfuras")) {
                product.setSellIn(product.getSellIn() - 1);
            }
        });
    }

    private void increaseBackstagePassQuality(Product product) {
        int sellIn = product.getSellIn();
        int quality = product.getQuality();
        if (sellIn <= 10 && sellIn > 5) {
            product.setQuality(quality + 2);
        } else if (sellIn > 10) {
            product.setQuality(quality + 1);
        } else if (sellIn > 1 && sellIn <= 5) {
            product.setQuality(quality + 3);
        } else if (sellIn == 1) {
            product.setQuality(0);
        }
    }

    private void increaseQuality(Product product) {
        if (product.getQuality() < 50) {
            product.setQuality(product.getQuality() + 1);
        }
    }
}
