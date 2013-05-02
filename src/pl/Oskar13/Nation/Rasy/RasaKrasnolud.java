package pl.Oskar13.Nation.Rasy;

import java.util.HashMap;

import org.bukkit.ChatColor;

import pl.Oskar13.Nation.RASY;

public class RasaKrasnolud extends RASY{

	
	
	
	public static HashMap<String, Integer> dmgAXE  = new HashMap<String,Integer>(4);
	
	
	public RasaKrasnolud()  {
		
		sila = 5;
		magia = 1;
		zrecz = 5;
		this.kolorNicku = ChatColor.DARK_PURPLE;
		isVIP = false;
		loadDMG();
	}
	
	
	
	public static void loadDMG() {
		if(!dmgAXE.containsKey("diamond")){
		dmgAXE.put("diamond", 3);
		dmgAXE.put("wood", 1);
		dmgAXE.put("gold", 2);
		dmgAXE.put("stone", 2);
		}
		
	}
	
	
}
