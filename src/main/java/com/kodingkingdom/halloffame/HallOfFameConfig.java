package com.kodingkingdom.halloffame;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public enum HallOfFameConfig {

	CODEOFFAME("halloffame.codeoffame");
	
	public final String config;
	
	private HallOfFameConfig(String Config){
		config=Config;}
		
	public static void loadConfig(){
		HallOfFamePlugin plugin = HallOfFamePlugin.getPlugin();
		FileConfiguration config = plugin.getConfig();
		
		try{
			plugin.hallOfFame.codeOfFame=new ItemStack(Material.BOOK_AND_QUILL);
			BookMeta codeMeta = (BookMeta)plugin.hallOfFame.codeOfFame.getItemMeta();
			codeMeta.setPages(config.getStringList(CODEOFFAME.config));
			plugin.hallOfFame.codeOfFame.setItemMeta(codeMeta);
			
			plugin.getLogger().info("Config successfully loaded");}
		
		catch(Exception e){
			plugin.getLogger().severe("Could not load config!");
			plugin.getLogger().severe("ERROR MESSAGE: "+e.getMessage());
			e.printStackTrace();
			config.set("halloffame.ERROR", true);}}}
