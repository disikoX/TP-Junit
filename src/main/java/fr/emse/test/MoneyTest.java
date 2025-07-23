package fr.emse.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
    private Money f12CHF;
    private Money f14CHF;
    private Money f7USD;
    private Money f21USD;

    Money m12CHF= new Money(12, "CHF");
    Money m14CHF= new Money(14, "CHF");

    @Before
    public void setUp() {
        f12CHF = new Money(12, "CHF");
        f14CHF = new Money(14, "CHF");
        f7USD = new Money(7, "USD");
        f21USD = new Money(21, "USD");
    }


    @Before
    public void testSimpleAdd() {
        Money expected = new Money(26, "CHF");
        IMoney result = f12CHF.add(f14CHF); // exécution de la méthode testé
        assertEquals(new Money(26, "CHF"), result);  // comparaison
    }

    @Test
    public void testEquals() {
        assertTrue(!m12CHF.equals(null));
        assertEquals(m12CHF, m12CHF);
        assertEquals(m12CHF, new Money(12, "CHF"));
        assertTrue(!m12CHF.equals(m14CHF));
    }

    @Test
    public void testMixedSimpleAdd() {
        Money[] expected = { f12CHF, f7USD };
        IMoney result = f7USD.add(f12CHF);
        assertEquals(new MoneyBag(expected), result);
    }


}