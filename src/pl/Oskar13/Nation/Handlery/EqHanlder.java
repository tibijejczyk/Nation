package pl.Oskar13.Nation.Handlery;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import pl.Oskar13.Nation.Statystyki;

public class EqHanlder {

	Statystyki stat;
	Player gracz;
public EqHanlder(Statystyki stat) {
	
	this.stat = stat;
	gracz = Bukkit.getPlayer(stat.nick);
}


public boolean changeRasa() {


	if(gracz.getInventory().contains(Material.DIAMOND, 10)){
		
	    gracz.getInventory().removeItem(new ItemStack[] {
                  new ItemStack(Material.getMaterial(264), 10) });
		return true;
	}
	return false; 
}



}
