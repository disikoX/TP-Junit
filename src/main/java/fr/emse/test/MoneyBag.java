package fr.emse.test;

import java.util.Vector;

public class MoneyBag implements IMoney {
    private Vector<Money> fMonies = new Vector<Money>();

    // Constructeurs
    public MoneyBag(Money m1, Money m2) {
        appendMoney(m1);
        appendMoney(m2);
    }

    public MoneyBag(Money[] moneyArray) {
        for (Money m : moneyArray) {
            appendMoney(m);
        }
    }

    public MoneyBag(MoneyBag bag) {
        for (Money m : bag.getMonies()) {
            appendMoney(m);
        }
    }



    // Méthodes IMoney
    @Override
    public IMoney add(IMoney m) {
        return m.addMoneyBag(this);
    }

    @Override
    public IMoney addMoney(Money m) {
        Money[] newBag = new Money[fMonies.size() + 1];
        fMonies.toArray(newBag);
        newBag[newBag.length - 1] = m;
        return new MoneyBag(newBag).simplify();
    }


    @Override
    public IMoney addMoneyBag(MoneyBag bag) {
        Vector<Money> all = new Vector<>(fMonies);
        all.addAll(bag.getMonies());
        return new MoneyBag(all.toArray(new Money[0])).simplify();
    }


    // Méthodes utilitaires
    private IMoney simplify() {
        if (fMonies.size() == 1) {
            return fMonies.firstElement();
        }
        return this;
    }

    private void appendMoney(Money m) {
        if (fMonies.isEmpty()) {
            fMonies.add(m);
        } else {
            int i = 0;
            while ((i < fMonies.size())
                    && (!(fMonies.get(i).currency().equals(m.currency())))) {
                i++;
            }
            if (i >= fMonies.size()) {
                fMonies.add(m);
            } else {
                fMonies.set(i, new Money(fMonies.get(i).amount() + m.amount(), m.currency()));
            }
        }
    }

    // Getter
    public Vector<Money> getMonies() {
        return fMonies;
    }

    // Égalité
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MoneyBag other = (MoneyBag) obj;

        if (fMonies.size() != other.fMonies.size()) return false;

        for (Money money : fMonies) {
            if (!other.fMonies.contains(money)) {
                return false;
            }
        }
        return true;
    }
}