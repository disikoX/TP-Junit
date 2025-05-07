package fr.emse.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyBagTest {
    Money f12CHF = new Money(12, "CHF");
    Money f14CHF = new Money(14, "CHF");
    Money f7USD = new Money(7, "USD");
    Money f21USD = new Money(21, "USD");

    @Before
    public void setUp() {

        MoneyBag fMB1 = new MoneyBag(f12CHF, f7USD);
        MoneyBag fMB2 = new MoneyBag(f14CHF, f21USD);
    }

    @Test
    public void testBagEquals() {
        MoneyBag fMB1 = new MoneyBag(f12CHF, f7USD);
        MoneyBag fMB2 = new MoneyBag(f14CHF, f21USD);

        assertTrue(!fMB1.equals(null));
        assertEquals(fMB1, fMB1);
        assertTrue(!fMB1.equals(f12CHF));
        assertTrue(!f12CHF.equals(fMB1));
        assertTrue(!fMB1.equals(fMB2));

    }

    @Test
    public void testMixedSimpleAdd() {
        // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
        Money bag[] = { f12CHF, f7USD };
        MoneyBag expected = new MoneyBag(bag);
        assertEquals(expected, f12CHF.add(f7USD));
    }

    @Test
    public void testBagSimpleAdd() {
        MoneyBag bag = new MoneyBag(new Money[]{f12CHF, f7USD});
        MoneyBag expected = new MoneyBag(new Money[]{f12CHF, f7USD,f21USD });
        assertEquals(expected, bag.add(f21USD));
    }

}