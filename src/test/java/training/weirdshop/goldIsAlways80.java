package training.weirdshop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class goldIsAlways80 {
    @Test
    public void goldAlways80Test() {

        //Arrange

        Item[] itemsOutput = {
                new Item("Gold Coin", 0, 80),

        };
        WeirdShop weirdShop = new WeirdShop(itemsOutput);

        // Act
        for (int day = 1; day <= 5; day++) {
            weirdShop.updateQuality();

        }

        Item[] itemsExpected = {
                new Item("Gold Coin", 0, 80),
        };

        assertThat(itemsOutput[0].sellIn).isEqualTo(itemsExpected[0].sellIn);
        assertThat(itemsOutput[0].quality).isEqualTo(itemsExpected[0].quality);
    }
}
