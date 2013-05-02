package pl.Oskar13.Nation.Listenersy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;

import pl.Oskar13.Nation.NationMain;
import pl.Oskar13.Nation.Statystyki;
import pl.Oskar13.Nation.Handlery.JoinHandler;

public class LoginListener implements Listener {

	NationMain plugin;
	public  boolean jestJakisGracz = false;
    public Player gracz;
    
	
	public Player getGracz() {
		if(jestJakisGracz)
		return gracz;
		else
	    return null;
	}
	
	public LoginListener(NationMain main) {
		plugin =  main;
		
	}
	
	public LoginListener() { }
	
	
	
	
	
//	@EventHandler(priority = EventPriority.HIGHEST)
//	public void listener(PlayerLoginEvent event) { 
//		jestJakisGracz = true;
//		gracz = event.getPlayer();
//		
//		if(gracz.hasPlayedBefore())
//		gracz.sendMessage(ChatColor.GREEN + "Witaj, " + gracz.getDisplayName() + " w swiecie walki i zniszczenia!");
//		else
//	    gracz.sendMessage(ChatColor.GREEN + "A wiec jestes tutaj poraz pierwszy? Przystap do dowolnej rasy i zdobadz podstawowy ekwpiunek.");	
//		
//		
//		NationMain.zaladujGracza(gracz);
//		
//	
//	}
//	
//	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void listener(PlayerJoinEvent event) { 
		jestJakisGracz = true;
		gracz = event.getPlayer();
		
		if(gracz.hasPlayedBefore()){
		gracz.sendMessage(ChatColor.GREEN + "Witaj, " + gracz.getDisplayName() + " w swiecie walki i zniszczenia!");
		event.setJoinMessage(null);
	}else{
	    gracz.sendMessage(ChatColor.GREEN + "A wiec jestes tutaj poraz pierwszy? Przystap do dowolnej rasy i zdobadz podstawowy ekwpiunek.");
		event.setJoinMessage(ChatColor.DARK_BLUE + gracz.getDisplayName() + " , jest tutaj po raz pierwszy! Przywitajcie go");
	}
		
		NationMain.zaladujGracza(gracz);
		Statystyki stat = Statystyki.getData(gracz.getDisplayName());
		
		new JoinHandler(stat);
		
	}
	
}
