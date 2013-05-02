package pl.Oskar13.Nation.Listenersy;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import pl.Oskar13.Nation.NationMain;
import pl.Oskar13.Nation.Statystyki;
import pl.Oskar13.Nation.Handlery.AttackHandler;
import pl.Oskar13.Nation.Handlery.ChatChandler;

public class AttackListener implements Listener {

	NationMain plugin;
    public Player gracz;
    
	

	
	public AttackListener(NationMain main) {
		plugin =  main;
		
	}
	
	public AttackListener() { }
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void listener(EntityDamageByEntityEvent event) { 

//if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
	Player player = (Player)event.getDamager();
	
	event.setDamage(new AttackHandler(Statystyki.getData(player.getDisplayName())).getDamage(event.getDamage()));
//}
		  
		
		
	}
	
}
