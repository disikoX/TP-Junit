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
        if (m == null) throw new IllegalArgumentException("Money object cannot be null");
        if (!m.currency().equals(this.currency())) {
            throw new IllegalArgumentException("Currencies must match: " + this.currency() + " vs " + m.currency());
        }
        return new Money(this.amount() + m.amount(), this.currency());
    }

    public int amount() {
        return fAmount; }

    public String currency() {
        return fCurrency; }

//    public Money add(Money m) {
//
//        return new Money(amount() + m.amount(), currency());
//    }


    // Il fallait modifier la method equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Money money = (Money) obj;
        return fAmount == money.fAmount && fCurrency.equals(money.fCurrency);
    }
}