package de.falsedeveloping.falseTools.Tools;

import static org.bukkit.Bukkit.getServer;

import de.falsedeveloping.falseTools.Main;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class AutoSmeltPick {

  private Main plugin;
  public AutoSmeltPick(Main plugin) {
    this.plugin = plugin;
  }
  public void addAutoSmeltPick() {
    ItemStack autosmeltpick = getAutoSmeltPick();
    NamespacedKey key = new NamespacedKey(plugin, "hotpickaxe");
    ShapedRecipe recipe = new ShapedRecipe(key, autosmeltpick);
    recipe.shape("###", " * ", " * ");
    recipe.setIngredient('#', Material.MAGMA_BLOCK);
    recipe.setIngredient('*', Material.DIAMOND);
    getServer().addRecipe(recipe);
  }

  public ItemStack getAutoSmeltPick() {
    ItemStack is = new ItemStack(Material.IRON_PICKAXE);
    is.addUnsafeEnchantment(Enchantment.DIG_SPEED, 8);
    ItemMeta meta = is.getItemMeta();
    meta.setDisplayName("§4§lHot Pickaxe");
    List<String> lores = new ArrayList<>();
    lores.add("Schmilzt automatisch Erze und bestimmte Blöcke");
    meta.setLore(lores);
    is.setItemMeta(meta);
    return is;
  }

}
