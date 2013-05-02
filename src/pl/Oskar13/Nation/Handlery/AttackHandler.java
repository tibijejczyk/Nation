package pl.Oskar13.Nation.Handlery;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import pl.Oskar13.Nation.Statystyki;
import pl.Oskar13.Nation.Rasy.RasaCzlowiek;
import pl.Oskar13.Nation.Rasy.RasaElf;
import pl.Oskar13.Nation.Rasy.RasaGuardian;
import pl.Oskar13.Nation.Rasy.RasaKrasnolud;

public class AttackHandler {

	Statystyki stat;
	private Player gracz;
public AttackHandler(Statystyki stat) {
	
	this.stat = stat;
	gracz = Bukkit.getPlayer(stat.nick);
}



public int getDamage(int getDamage) {

	RasaKrasnolud.loadDMG();
	
	if(stat.getKlasa() instanceof RasaElf) {
		if(gracz.getItemInHand().getType() == Material.BOW) {
			if(gracz.hasPermission("Oskar13.vip")) {
				return getDamage + 2;
			}else{
				return getDamage + 1;
			}
		}
	}
	
	if(stat.getKlasa() instanceof RasaKrasnolud) {
		if(gracz.getItemInHand().getType() == Material.DIAMOND_AXE){
			
			if(gracz.hasPermission("Oskar13.vip")) {

				return getDamage + RasaKrasnolud.dmgAXE.get("diamond") + 1;
				
			}else{
				
				return getDamage + RasaKrasnolud.dmgAXE.get("diamond");
			}
		}
		
		
		if(gracz.getItemInHand().getType() == Material.STONE_AXE){
			
			if(gracz.hasPermission("Oskar13.vip")) {

				return getDamage + RasaKrasnolud.dmgAXE.get("stone") + 1;
				
			}else{
				
				return getDamage + RasaKrasnolud.dmgAXE.get("stone");
			}
		}
		
		
	}
	if(stat.getKlasa() instanceof RasaCzlowiek) {
		
		if(gracz.getItemInHand().getType() == Material.STONE_SWORD || gracz.getItemInHand().getType() == Material.GOLD_SWORD || gracz.getItemInHand().getType() == Material.DIAMOND_SWORD || gracz.getItemInHand().getType() == Material.WOOD_SWORD){
			if(gracz.hasPermission("Oskar13.vip")) {
			return getDamage + 3;
			}else{
				
				return getDamage + 2;
			}
		}
		
	}
	
	if(stat.getKlasa() instanceof RasaGuardian) {
		
return getDamage + 3;
		
	}
	
	
	
	if(gracz.getItemInHand() == null) {
	return stat.getKlasa().getSila();
	}
	
	
	
	return getDamage;
	
}




}
