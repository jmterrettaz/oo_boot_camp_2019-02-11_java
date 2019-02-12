/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

package quantity;

// Understands a particular measurement
public class Quantity {
    private final double amount;
    private final Unit unit;

    Quantity(double amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        return this == other ||
                other != null && other.getClass() == Quantity.class && this.equals((Quantity) other);
    }

    private boolean equals(Quantity other) {
        return this.amount == convertedAmount(other);
    }

    private double convertedAmount(Quantity other) {
        return this.unit.convertedAmount(other.amount, other.unit);
    }

    @Override
    public int hashCode() {
        return unit.hashCode(amount);
    }

    public Quantity plus(Quantity other) {
        return new Quantity(this.amount + convertedAmount(other), this.unit);
    }

    public Quantity negate() {
        return new Quantity(-amount, unit);
    }

    public Quantity minus(Quantity other) {
        return this.plus(other.negate());
    }
}
