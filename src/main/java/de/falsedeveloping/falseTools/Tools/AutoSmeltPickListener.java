package de.falsedeveloping.falseTools.Tools;

import de.falsedeveloping.falseTools.Main;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class AutoSmeltPickListener implements Listener {

  private final Map<Material, Material> smeltblocks = new HashMap<>();
  private Main plugin;

  public AutoSmeltPickListener(Main plugin) {
    this.plugin = plugin;
    smeltblocks.put(Material.IRON_ORE, Material.IRON_INGOT);
    smeltblocks.put(Material.GOLD_ORE, Material.GOLD_INGOT);
    smeltblocks.put(Material.NETHERRACK, Material.NETHER_BRICK);
    smeltblocks.put(Material.ANCIENT_DEBRIS, Material.NETHERITE_SCRAP);
    smeltblocks.put(Material.STONE, Material.STONE);
    smeltblocks.put(Material.CLAY, Material.TERRACOTTA);
    smeltblocks.put(Material.SAND, Material.GLASS);
  }

  @EventHandler
  public void onSmeltMine(BlockBreakEvent e) {
    Player p = e.getPlayer();
    ItemStack item = p.getInventory().getItemInMainHand();
    if (item.getType() != Material.IRON_PICKAXE || !item.getItemMeta().getDisplayName().equals("§4§lHot Pickaxe")) return;
    if (smeltblocks.containsKey(e.getBlock().getType())) {
      e.setDropItems(false);
      Material drop = smeltblocks.get(e.getBlock().getType());
      e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(drop));
    }
  }
}
