import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient meat;
    @Mock
    Ingredient tomato;
    @Mock
    Ingredient cheese;
    @Mock
    Ingredient ingredient;

    @Before
    public void init() {
        burger = new Burger();
    }

    @Test
    public void isBunSetTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void isIngredientAddedTest(){
        burger.addIngredient(meat);
        burger.addIngredient(tomato);
        burger.addIngredient(cheese);
        assertEquals(3,burger.ingredients.size());
        assertTrue(burger.ingredients.contains(meat));
        assertTrue(burger.ingredients.contains(tomato));
        assertTrue(burger.ingredients.contains(cheese));
    }

    @Test
    public void isIngredientRemovedTest(){
        burger.addIngredient(meat);
        burger.addIngredient(tomato);
        burger.addIngredient(cheese);
        burger.removeIngredient(0);
        assertEquals(2,burger.ingredients.size());
    }

    @Test
    public void isIngredientMovedTest(){
        burger.ingredients.addAll(Arrays.asList(meat, tomato));
        List<Ingredient> expected = new ArrayList<>(Arrays.asList(tomato, meat));
        burger.moveIngredient(0, 1);
       assertEquals(expected,burger.ingredients);
    }

    @Test
    public void returnCorrectPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.00f);
        Mockito.when(ingredient.getPrice()).thenReturn(150.00f);
        float actual = burger.getPrice();
        assertEquals(350.00f, actual, 0);
    }

    @Test
    public void returnCorrectReceiptTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.00f);
        Mockito.when(ingredient.getPrice()).thenReturn(150.00f);
        Mockito.when(bun.getName()).thenReturn("Круглая");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("мясо");
        String expected = String.format("(==== Круглая ====)%n" + "= sauce мясо =%n" + "(==== Круглая ====)%n" + "%nPrice: 350,000000%n");
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}
