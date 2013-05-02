package pl.Oskar13.Nation;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NationCommand implements CommandExecutor {

	
	public NationCommand() { }
	@Override
	public boolean onCommand(CommandSender gracz, Command komenda, String alias,
			String[] arg) {
    Player player = (Player)gracz;
		NationMain.log("Wpisano komende nation");
		if(komenda.getName().equals("nation") && arg.length == 0) {
			//printInfo(gracz);
		
			gracz.sendMessage(ChatColor.GREEN + "Jesli nie znasz ras wpisz '/nation rasa info'");
		}else if(komenda.getName().equals("nation") && arg[0].equals("rasa") && arg.length == 2){
			
			
			Statystyki stat = Statystyki.getData(gracz.getName());		
			stat.setRasa(arg[1]);
			
			player.getInventory().clear();
			NationMain.getStartEQ(player);
			
			
			
		}else if(komenda.getName().equals("nation") && arg[0].equals("rasa") && arg.length == 1) {
			Statystyki stat = Statystyki.getData(gracz.getName());
			stat.reloadCustomConfig();
			gracz.sendMessage("Twoja rasa to: " + stat.getRasa());
		}
		
		
		
		
		
		
		else if(komenda.getName().equals("nation") && arg[0].equals("rasa") && arg[1].equals("info") &&  arg.length == 2) {
			
			gracz.sendMessage(ChatColor.GREEN + "Rasy do wyboru to: '");
			gracz.sendMessage(ChatColor.GOLD +  "~ Guardian (RASA VIP)");
			gracz.sendMessage(ChatColor.GREEN + "~ Elf");
			gracz.sendMessage(ChatColor.GREEN + "~ Krasnolud");
			gracz.sendMessage(ChatColor.GREEN + "~ Czlowiek");
			
			gracz.sendMessage(ChatColor.RED + "| Mozesz tez uzyc komendy '/nation rasa info <nazwa_rasy> aby poznac tajemnice kazdej z postaci! | ");
		}else if(komenda.getName().equals("nation") && arg[0].equals("rasa") && arg[1].equals("info")  && arg.length == 3) {
			
			
			switch(arg[2]) {
				
				case "Krasnolud": gracz.sendMessage(ChatColor.UNDERLINE + "Krasnal to bardzo dobra rasa");
				case "Guardian": gracz.sendMessage(ChatColor.UNDERLINE + "Guardian to bardzo dobra rasa");
				case "Czlowiek": gracz.sendMessage(ChatColor.UNDERLINE + "Czlowiek to bardzo dobra rasa");
				case "Elf": gracz.sendMessage(ChatColor.UNDERLINE + "Elf to bardzo dobra rasa");
			
			}
			
			

			
			
		}
		
		
		
		
		
		
		
		
		
		return false;
	}


	
	private void printInfo(CommandSender gracz) {
		gracz.sendMessage("Witaj w  œwiecie walki i zniszczenia!");
		
	}
	
}
