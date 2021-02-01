package de.falsedeveloping.falseTools;

import de.falsedeveloping.falseTools.Tools.AutoSmeltPick;
import de.falsedeveloping.falseTools.Tools.AutoSmeltPickListener;
import de.falsedeveloping.falseTools.Tools.EmeraldPickaxe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  private EmeraldPickaxe emeraldPickaxe;
  private AutoSmeltPick autoSmeltPick;

  public void onEnable() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new AutoSmeltPickListener(this), this);


    emeraldPickaxe = new EmeraldPickaxe(this);
    autoSmeltPick = new AutoSmeltPick(this);

    emeraldPickaxe.addEmeraldPickaxe();
    autoSmeltPick.addAutoSmeltPick();
  }

  public EmeraldPickaxe getEmeraldPickaxe() {
    return emeraldPickaxe;
  }
}
