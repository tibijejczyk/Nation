package pl.Oskar13.Nation.Handlery;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import pl.Oskar13.Nation.Statystyki;

public class JoinHandler {

	Statystyki stat;
	
public JoinHandler(Statystyki stat) {
	
	this.stat = stat;
	setNick();
}



public void setNick() {

	Player gracz = Bukkit.getPlayer(stat.nick);
	gracz.setCustomName(gracz.getDisplayName() + " ~ " + stat.getKlasa().kolorNicku() + stat.getRasa());
	gracz.setCustomNameVisible(true);
	
}


public static void randItem(Player gracz) {
	
	Random rand = new Random(100);
	
	Random rand1 = new Random(100);
	
	
	if(rand1.nextInt() < 10) {
		
	gracz.getInventory().addItem(new ItemStack(rand.nextInt(), 1));	
	}
		
		
		
	}
	
	
}





