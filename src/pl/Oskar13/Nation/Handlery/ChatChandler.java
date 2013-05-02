package pl.Oskar13.Nation.Handlery;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import pl.Oskar13.Nation.NationMain;
import pl.Oskar13.Nation.Statystyki;

public class ChatChandler {

	
	Statystyki statystyki;
public ChatChandler(Statystyki stat) { 
	
	statystyki = stat;
	
}


public boolean mozePisac() {
	NationMain.log("Klasa to : " + statystyki.getKlasa());
	
	
	
	if(statystyki.getKlasa() != null) {
		return true;
	}else{
	
	Player player = Bukkit.getPlayer(statystyki.nick);
	player.sendMessage(ChatColor.RED + "Nie wybrales zadnej z ras! Uzyj: '/nation rasa'");
	
	}
	
	return false;
}



}
