package me.yaros.GravityChange;

import org.bukkit.plugin.java.JavaPlugin;

import me.yaros.GravityChange.commands.EndCommand;
import me.yaros.GravityChange.commands.GravityCommand;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new GravityCommand(this);
		new EndCommand(this);
	}
}
