package fr.emse.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoneyBagTest {
    private Money f12CHF;
    private Money f14CHF;
    private Money f7USD;
    private Money f21USD;
    private MoneyBag fMB1;
    private MoneyBag fMB2;

    @Before
    public void setUp() {

        f12CHF = new Money(12, "CHF");
        f14CHF = new Money(14, "CHF");
        f7USD = new Money(7, "USD");
        f21USD = new Money(21, "USD");
        fMB1 = new MoneyBag(f12CHF, f7USD);
        fMB2 = new MoneyBag(f14CHF, f21USD);

    }

    @Test
    public void testBagEquals() {
        assertTrue(!fMB1.equals(null));
        assertEquals(fMB1, fMB1);
        assertTrue(!fMB1.equals(f12CHF));
        assertTrue(!f12CHF.equals(fMB1));
        assertTrue(!fMB1.equals(fMB2));

    }

// TODO : Corriger testSimplifytoMoney()

    @Test
    public void testBagSimpleAdd() {
        IMoney result = fMB1.add(f14CHF);
        Money[] expected = { new Money(12 + 14, "CHF"), f7USD };
        assertEquals(new MoneyBag(expected), result);
    }

    @Test
    public void testSimpleBagAdd() {
        IMoney result = f14CHF.add(fMB1);
        Money[] expected = { new Money(12 + 14, "CHF"), f7USD };
        assertEquals(new MoneyBag(expected), result);
    }

    @Test
    public void testBagBagAdd() {
        IMoney result = fMB1.add(fMB2);
        Money[] expected = {
                new Money(12 + 14, "CHF"),
                new Money(7 + 21, "USD")
        };
        assertEquals(new MoneyBag(expected), result);
    }

    //@Test
    //public void testSimplifyToMoney() {
         //Money neg12CHF = new Money(-12, "CHF");
        //IMoney bag = new MoneyBag(f12CHF, f7USD).add(neg12CHF);
        //(f7USD, bag);
    //}

}