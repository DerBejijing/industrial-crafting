package io.github.derbejijing.ic.crafting.chemical;

import io.github.derbejijing.ic.chemical.ChemicalItem;

public class ChemicalComponent {
    public ChemicalItem chemical;
    public boolean is_consumed;
    public int amount;

    public ChemicalComponent(ChemicalItem chemical, int amount, boolean is_consumed) {
        this.chemical = chemical;
        this.amount = amount;
        this.is_consumed = is_consumed;
    }
}
