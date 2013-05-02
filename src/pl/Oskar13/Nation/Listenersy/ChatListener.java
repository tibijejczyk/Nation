package pl.Oskar13.Nation.Listenersy;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import pl.Oskar13.Nation.NationMain;
import pl.Oskar13.Nation.Statystyki;
import pl.Oskar13.Nation.Handlery.ChatChandler;

public class ChatListener implements Listener {

	NationMain plugin;
    public Player gracz;
    
	

	
	public ChatListener(NationMain main) {
		plugin =  main;
		
	}
	
	public ChatListener() { }
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void listener(AsyncPlayerChatEvent event) { 

		gracz = event.getPlayer();

		
		boolean chat  = new ChatChandler(Statystyki.getData(event.getPlayer().getDisplayName())).mozePisac();
		
	   if(!chat) {
		   event.setMessage(null);
		   event.setCancelled(true);
		   
	   }
		
		
		
	}
	
}
