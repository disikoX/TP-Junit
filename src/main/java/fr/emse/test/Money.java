package fr.emse.test;

interface IMoney {
    public IMoney add(IMoney aMoney);
}

class Money {
    private int fAmount;
    private String fCurrency;
    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    public Money add(Money m) {
        if (m.currency().equals(currency()))
            return new Money(amount() + m.amount(), currency());
        // return new Money(this, m);
    }


    public int amount() {
        return fAmount; }

    public String currency() {
        return fCurrency; }

    public Money add(Money m) {

        return new Money(amount() + m.amount(), currency());
    }

    // Il fallait modifier la method equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Money money = (Money) obj;
        return fAmount == money.fAmount && fCurrency.equals(money.fCurrency);
    }
}