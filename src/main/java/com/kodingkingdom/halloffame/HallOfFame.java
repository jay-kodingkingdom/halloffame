package com.kodingkingdom.halloffame;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

import com.worldcretornica.plotme.Plot;
import com.worldcretornica.plotme.PlotManager;

public class HallOfFame{	
		
	ItemStack codeOfFame;
	HallOfFamePlugin plugin;

	public void Live(){
		HallOfFameConfig.loadConfig();
		Listener hallOfFameListener = new Listener(){
			@EventHandler(priority=EventPriority.HIGH)
			public void onInventoryOpen(InventoryOpenEvent e){
				e.getPlayer().getInventory().setItem(27, codeOfFame.clone());}};
		Bukkit.getServer().getPluginManager().registerEvents(hallOfFameListener, plugin);
		CommandExecutor hallOfFameCmd = new CommandExecutor(){
			public boolean onCommand(CommandSender sender, Command command,
					String label, String[] args) {
				
				if (sender instanceof Player){
					Player player = (Player)sender;
					for (Plot plot : PlotManager.getPlots(player.getWorld()).values()) {
						if (plot.owner.equalsIgnoreCase("HallOfFame")&&
							plot.isAllowed(player.getName())) {
							player.teleport(PlotManager.getPlotHome(player.getWorld(), plot));
							break;}}}
				return true;}};
		plugin.getCommand("halloffame").setExecutor(hallOfFameCmd);
		plugin.getCommand("hof").setExecutor(hallOfFameCmd);}
	public void Die(){}
	
	HallOfFame(HallOfFamePlugin Plugin){
		plugin=Plugin;}}

