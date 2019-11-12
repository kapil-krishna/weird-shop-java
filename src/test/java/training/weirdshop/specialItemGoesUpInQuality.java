package training.weirdshop;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class specialItemGoesUpInQuality {
    @Test
    public void brieGoesUpInQuality() {

        //Arrange

        Item[]itemsOutput={
                new Item("Aged Brie",10,30),
                new Item("Aged Brie",15,20)

        };
        WeirdShop weirdShop=new WeirdShop(itemsOutput);

        // Act
        for(int day=1;day<=5;day++){
            weirdShop.updateQuality();

        }

        Item[]itemsExpected={
                new Item("normal item 1",5,35),
                new Item("normal item 2",10,25),
        };

        assertThat(itemsOutput[0].sellIn).isEqualTo(itemsExpected[0].sellIn);
        assertThat(itemsOutput[0].quality).isEqualTo(itemsExpected[0].quality);
        assertThat(itemsOutput[1].sellIn).isEqualTo(itemsExpected[1].sellIn);
        assertThat(itemsOutput[1].quality).isEqualTo(itemsExpected[1].quality);

    }

    @Test
    public void backstagePassGoesUpInQualityIfSellInGreaterThanZero() {

        //Arrange

        Item[]itemsOutput={
                new Item("Backstage Pass",12,30),
                new Item("Backstage Pass",6,20),

        };
        WeirdShop weirdShop=new WeirdShop(itemsOutput);

        // Act
        for(int day=1;day<=5;day++){
            weirdShop.updateQuality();

        }

        Item[]itemsExpected={
                new Item("Backstage Pass",7,38),
                new Item("Backstage Pass",1,34),
        };

        assertThat(itemsOutput[0].sellIn).isEqualTo(itemsExpected[0].sellIn);
        assertThat(itemsOutput[0].quality).isEqualTo(itemsExpected[0].quality);
        assertThat(itemsOutput[1].sellIn).isEqualTo(itemsExpected[1].sellIn);
        assertThat(itemsOutput[1].quality).isEqualTo(itemsExpected[1].quality);

    }

    @Test
    public void backstagePassIsZeroIfSellInIsNegative() {

        //Arrange

        Item[]itemsOutput={
                new Item("Backstage Pass",4,20),
                new Item("Backstage Pass",-1,0)

        };
        WeirdShop weirdShop=new WeirdShop(itemsOutput);

        // Act
        for(int day=1;day<=5;day++){
            weirdShop.updateQuality();

        }

        Item[]itemsExpected={
                new Item("Backstage Pass",-1,0),
                new Item("Backstage Pass",-6,0)
        };

        assertThat(itemsOutput[0].sellIn).isEqualTo(itemsExpected[0].sellIn);
        assertThat(itemsOutput[0].quality).isEqualTo(itemsExpected[0].quality);
        assertThat(itemsOutput[1].sellIn).isEqualTo(itemsExpected[1].sellIn);
        assertThat(itemsOutput[1].quality).isEqualTo(itemsExpected[1].quality);

    }
}

