package io.github.derbejijing.ic.chemical;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.derbejijing.ic.chemical.property.ChemicalPurity;
import io.github.derbejijing.ic.chemical.property.ChemicalReactivity;
import io.github.derbejijing.ic.chemical.property.ChemicalToxicity;

public class Chemical {
    private Material material;
    private int custom_model_data;
    private ChemicalPurity purity;
    private ChemicalToxicity toxicity;
    private ChemicalReactivity reactivity;
    private int count;

    public Chemical(Material material, int custom_model_data, ChemicalPurity purity, ChemicalToxicity toxicity, ChemicalReactivity reactivity, int count) {
        this.material = material;
        this.custom_model_data = custom_model_data;
        this.purity = purity;
        this.toxicity = toxicity;
        this.reactivity = reactivity;
        this.count = count;
    }


    public static Chemical get_from(ItemStack item_stack) {
        if(item_stack == null || item_stack.getType().equals(Material.AIR)) return null;
        
        ItemMeta meta = item_stack.getItemMeta();
        if(meta == null || !meta.hasCustomModelData()) return null;

        int id = meta.getCustomModelData();

        Class<? extends Chemical> chemical_class = ChemicalItem.get_by_id(id);

        if(chemical_class == null) return null;

        try {
            Chemical chemical = chemical_class.getConstructor(int.class, ChemicalPurity.class).newInstance(item_stack.getAmount(), ChemicalPurity.HEAVY_CONTAMINATION);
            return chemical;
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}



/* Notes
 * there should be some sort of Chemical.from() method, so that basically any regular block can be used in recipes
 */