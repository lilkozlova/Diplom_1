import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunPriceParamTest {
    private final String name;
    private final float price;

    public BunPriceParamTest(String name, float price){
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "название булки = {0}, цена булки = {1}")
    public static Object[][] getBunName() {
        return new Object[][] {
                {"Двойной", 550.00f},
                {"Двойной", -550.00f},
                {"Двойной", 0},
                {"Двойной", 1.1f},
                {"Двойной", 55000000},
        };
    }
    @Test
    public void returnPriceTest(){
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        assertEquals("несоответствие цены булочки", price, actual, 0);
    }
}
