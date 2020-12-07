package me.yaros.GravityChange.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import me.yaros.GravityChange.Main;

public class GravityCommand implements CommandExecutor {
	private Main plugin;
	
	public GravityCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("gravitystart").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		p.getServer().getScheduler().cancelTasks(this.plugin);
		long delay = Long.parseLong(args[0], 10)*20*60;
		int duration = Integer.parseInt(args[1]);
		Bukkit.broadcastMessage("Attention! No-gravity timer triggered! You have " + delay/20 + " seconds before gravity disappears for the first time!");
		BukkitScheduler sched = p.getServer().getScheduler();
		sched.scheduleSyncRepeatingTask(this.plugin, new Runnable() {
			
			@Override
			public void run() {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give @e minecraft:levitation " + duration + " 1 true");
			}
			
		}, delay, delay);
		
		return false;
	}
}
