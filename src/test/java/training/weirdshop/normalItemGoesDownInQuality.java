package training.weirdshop;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class normalItemGoesDownInQuality {
    @Test
    public void goesDownByOneIfSellInIsZeroOrMoreTest(){

        //Arrange

        Item[]itemsOutput={
        new Item("normal item 1",10,30),
        new Item("normal item 2",15,20)

        };
        WeirdShop weirdShop=new WeirdShop(itemsOutput);

        // Act
        for(int day=1;day<=5;day++){
        weirdShop.updateQuality();

        }

        Item[]itemsExpected={
        new Item("normal item 1",5,25),
        new Item("normal item 2",10,15),
        };

        assertThat(itemsOutput[0].sellIn).isEqualTo(itemsExpected[0].sellIn);
        assertThat(itemsOutput[0].quality).isEqualTo(itemsExpected[0].quality);
        assertThat(itemsOutput[1].sellIn).isEqualTo(itemsExpected[1].sellIn);
        assertThat(itemsOutput[1].quality).isEqualTo(itemsExpected[1].quality);

    }

    @Test
    public void goesDownByTwoIfSellInIsNegativeTest(){

        //Arrange

        Item[]itemsOutput={
                new Item("normal item 1",4,20),
                new Item("normal item 2",-1,30)

        };
        WeirdShop weirdShop=new WeirdShop(itemsOutput);

        // Act
        for(int day=1;day<=5;day++){
            weirdShop.updateQuality();

        }

        Item[]itemsExpected={
                new Item("normal item 1",-1,14),
                new Item("normal item 2",-6,20),
        };

        assertThat(itemsOutput[0].sellIn).isEqualTo(itemsExpected[0].sellIn);
        assertThat(itemsOutput[0].quality).isEqualTo(itemsExpected[0].quality);
        assertThat(itemsOutput[1].sellIn).isEqualTo(itemsExpected[1].sellIn);
        assertThat(itemsOutput[1].quality).isEqualTo(itemsExpected[1].quality);

    }
}
