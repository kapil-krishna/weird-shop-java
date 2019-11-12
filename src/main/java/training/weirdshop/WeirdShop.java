package training.weirdshop;

class WeirdShop {
    private Item[] items;

    public WeirdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (!isItemSpecial(item)) {
                changeNormalQuality(item);
            }
            else if (item.name.equals("Aged Brie")) {
                changeBrieQuality(item);
            }
            else if (item.name.equals("Backstage Pass")) {
               changeBackstagePassQuality(item);
            }
        }
    }


//    void updateQuality() {
//        for (Item item : items) {
//            if (!item.name.equals("Aged Brie")
//                    && !item.name.equals("Backstage Pass")) {
//                if (qualityGreaterThan(item, 0)) {
//                    if (!item.name.equals("Gold Coin")) {
//                        changeQuality(item, -1);
//                    }
//                }
//            } else {
//                if (qualityLessThan(item, 50)) {
//                    changeQuality(item, 1);
//
//                    if (item.name.equals("Backstage Pass")) {
//                        if (sellInLessThan(item, 12)) {
//                            if (qualityLessThan(item, 0)) {
//                                changeQuality(item, 1);
//                            }
//                        }
//
//                        if (sellInLessThan(item, 7)) {
//                            if (qualityLessThan(item, 50)) {
//                                changeQuality(item, 1);
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!item.name.equals("Gold Coin")) {
//                changeQuality(item, -1);
//            }
//
//            if (sellInLessThan(item, 0)) {
//                if (!item.name.equals("Aged Brie")) {
//                    if (!item.name.equals("Backstage Pass")) {
//                        if (qualityGreaterThan(item, 0)) {
//                            if (!item.name.equals("Gold Coin")) {
//                                changeQuality(item, -1);
//                            }
//                        }
//                    } else {
//                        item.quality = 0;
//                    }
//                } else {
//                    if (qualityLessThan(item, 50)) {
//                        changeQuality(item, 1);
//                    }
//                }
//            }
//        }
//    }

    public boolean qualityLessThan (Item item, int number) {
        return item.quality < number;
    }

    public boolean qualityGreaterThan (Item item, int number) {
        return item.quality > number;
    }

    public boolean sellInLessThan (Item item, int number) {
        return item.sellIn < number;
    }

    public void changeQuality (Item item, int toAdd) {
        item.quality += toAdd;
    }

    public boolean isItemSpecial (Item item) {
        return ((item.name == "Gold Coin") || (item.name == "Backstage Pass") || (item.name == "Aged Brie"));
    }

    public void reduceSellIn(Item item) {
        item.sellIn -= 1;
    }

    public void changeNormalQuality (Item item) {
        if (qualityGreaterThan(item, 1)) {
            if (sellInLessThan(item, 1)) {
                changeQuality(item, -2);
            } else {
                changeQuality(item, -1);
            }
        }
        if (item.quality == 1) {
            changeQuality(item, -1);
        }
        reduceSellIn(item);
    }

    public void changeBrieQuality (Item item) {
        changeQuality(item, 1);
        reduceSellIn(item);
    }

    public void changeBackstagePassQuality (Item item) {
        if (item.sellIn > 10) {
            changeQuality(item, 1);
            reduceSellIn(item);
        } else if ((item.sellIn <= 10) && (item.sellIn >= 6)) {
            changeQuality(item, 2);
            reduceSellIn(item);
        } else if ((0 <= item.sellIn) && (item.sellIn <= 5)) {
            changeQuality(item, 3);
            reduceSellIn(item);
        } else {
            reduceSellIn(item);
        }
    }
}

