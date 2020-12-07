package me.yaros.GravityChange.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.yaros.GravityChange.Main;

public class EndCommand implements CommandExecutor {
	private Main plugin;
	
	public EndCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("gravitystop").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		Player p = (Player) sender;
		p.getServer().broadcastMessage("Stopping gravity changer!");
		p.getServer().getScheduler().cancelTasks(this.plugin);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect clear @e minecraft:levitation");
		return false;
	}
}