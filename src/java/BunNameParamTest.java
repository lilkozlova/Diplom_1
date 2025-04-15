import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
    public class BunNameParamTest {
        private final String name;
        private final float price;

        public BunNameParamTest(String name, float price){
            this.name = name;
            this.price = price;
        }

    @Parameterized.Parameters(name = "название булки = {0}, цена булки = {1}")
        public static Object[][] getBunName() {
            return new Object[][] {
                    {"", 550},
                    {null, 550},
                    {"Оады двшп фджывлп фдвлпр фждывл фыдлвоа фшывоад жвшаф", 550},
                    {"%ur&#", 550},
                    {"Двойной", 550},
            };
        }
    @Test
    public void returnNameTest(){
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        assertEquals("несоответствие названия булочки", name, actual);
    }
}
