package com.kodingkingdom.halloffame;
import java.util.logging.Level;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class HallOfFamePlugin extends JavaPlugin implements Listener{
		
	HallOfFame hallOfFame;
	
	@Override
    public void onEnable(){
    	hallOfFame=new HallOfFame(this);
    	hallOfFame.Live();} 
    @Override
    public void onDisable(){hallOfFame.Die();}
    
    static HallOfFamePlugin instance=null;
    public HallOfFamePlugin(){
    	super();
    	instance=this;}
    public static HallOfFamePlugin getPlugin(){
    	return instance;}
    public static void say(String msg){
    	instance.getLogger().log(Level.INFO//Level.FINE
    			, msg);}
    public static void debug(String msg){
    	instance.getLogger().log(Level.INFO//Level.FINE
    			, msg);}}