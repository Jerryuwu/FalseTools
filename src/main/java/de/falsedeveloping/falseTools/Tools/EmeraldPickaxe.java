package de.falsedeveloping.falseTools.Tools;

import static org.bukkit.Bukkit.getServer;

import de.falsedeveloping.falseTools.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class EmeraldPickaxe {

  private Main plugin;
  public EmeraldPickaxe(Main plugin) {
    this.plugin = plugin;
  }

  public void addEmeraldPickaxe() {
    ItemStack emeraldPickaxe = getEmeraldPickaxeItem();
    NamespacedKey key = new NamespacedKey(plugin, "emeraldpickaxe");
    ShapedRecipe emeraldPickaxeRecipe = new ShapedRecipe(key, emeraldPickaxe);
    emeraldPickaxeRecipe.shape("###", " * ", " * ");
    emeraldPickaxeRecipe.setIngredient('#', Material.EMERALD_BLOCK);
    emeraldPickaxeRecipe.setIngredient('*', Material.DIAMOND);
    getServer().addRecipe(emeraldPickaxeRecipe);
  }

  public ItemStack getEmeraldPickaxeItem() {
    ItemStack is = new ItemStack(Material.NETHERITE_PICKAXE);
    is.addUnsafeEnchantment(Enchantment.DIG_SPEED, 8);
    ItemMeta meta = is.getItemMeta();
    meta.setDisplayName("§aEmerald Pickaxe");
    is.setItemMeta(meta);
    return is;
  }

}
