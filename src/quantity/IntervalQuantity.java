/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

package quantity;

// Understands a particular measurement
public class IntervalQuantity {
    private final double amount;
    private final Unit unit;

    IntervalQuantity(double amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        return this == other ||
                other != null && other.getClass() == IntervalQuantity.class && this.equals((IntervalQuantity) other);
    }

    private boolean equals(IntervalQuantity other) {
        return this.isCompatible(other) && this.amount == convertedAmount(other);
    }

    private boolean isCompatible(IntervalQuantity other) {
        return this.unit.isCompatible(other.unit);
    }

    private double convertedAmount(IntervalQuantity other) {
        return this.unit.convertedAmount(other.amount, other.unit);
    }

    @Override
    public int hashCode() {
        return unit.hashCode(amount);
    }
}
