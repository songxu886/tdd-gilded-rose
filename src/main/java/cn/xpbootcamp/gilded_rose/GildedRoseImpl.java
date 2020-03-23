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
            }

            if (!product.getName().equals("Sulfuras")) {
                product.setSellIn(product.getSellIn() - 1);
            }
        });
    }

    private void increaseQuality(Product product) {
        if (product.getQuality() < 50) {
            product.setQuality(product.getQuality() + 1);
        }
    }
}
