package fr.emse.test;

interface IMoney {
    IMoney add(IMoney aMoney);
    IMoney addMoney(Money m);
    IMoney addMoneyBag(MoneyBag mb);
}

class Money implements IMoney {
    private int fAmount;
    private String fCurrency;
    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    @Override
    public IMoney add(IMoney m) {
        return m.addMoney(this);
    }

    @Override
    public IMoney addMoney(Money m) {
        if (m.currency().equals(currency())) {
            return new Money(amount() + m.amount(), currency());
        }
        return new MoneyBag(this, m);
    }

    @Override
    public IMoney addMoneyBag(MoneyBag bag) {
        return bag.addMoney(this);
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