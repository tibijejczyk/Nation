package pl.Oskar13.Nation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import net.minecraft.server.v1_5_R2.Material;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_5_R2.command.ColouredConsoleSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import pl.Oskar13.Nation.Listenersy.AttackListener;
import pl.Oskar13.Nation.Listenersy.ChatListener;
import pl.Oskar13.Nation.Listenersy.LoginListener;
import pl.Oskar13.Nation.Rasy.RasaCzlowiek;

public class NationMain extends JavaPlugin {

//Plugin dla raxona za 5 stow
    private String copyright = "Zastrzegam sobie praw autorskich do tego pluginu, tak jak i do edytowania go! Oskar Polak 2013";
    public static Logger log; 
    
    public static NationMain instance;
    
    private ColouredConsoleSender sender;
    public static  HashMap<String, Statystyki> GRACZE;
    public static ArrayList SKILE = new ArrayList();
	public void onEnable()  { 
		log = Bukkit.getLogger();
		instance  = this;
		GRACZE = new HashMap<String,Statystyki>();
		
		
	
		log(ChatColor.RED + "Nation gamemode uruchomiony!");
		log(ChatColor.RED + "Nation by Oskar13!");
		
		
		installListeners();
		
		
		
		// komendy
		getCommand("nation").setExecutor(new NationCommand());
	
	}
	
	
	private void installListeners() {
		getServer().getPluginManager().registerEvents(new LoginListener(this), this);
		getServer().getPluginManager().registerEvents(new ChatListener(this), this);
		getServer().getPluginManager().registerEvents(new AttackListener(this), this);
	}
	
	

public static void getStartEQ(Player gracz) {
    Statystyki stat = Statystyki.getData(gracz.getDisplayName());
ArrayList<ItemStack> array = new ArrayList<ItemStack>();

    
    if(stat.getKlasa() instanceof RasaCzlowiek){
    	
    	log("Metoda czlowieka w NationMain dodawanie itemow");
    }
    
    

    	
    	gracz.getInventory().addItem(new ItemStack(264, 10));
    
    
    
   
    
  
	}
	
	public static  void zaladujGracza(Player player) {
		FileConfiguration ustawienia = null;
		File plikGracza = new File("plugins" + File.separator + "Nation" + File.separator + "Gracze" + File.separator + player.getDisplayName() + ".yml");
		
		
	if(plikGracza.exists()) {
        log("Plik gracza  istnieje");
	}else{

		try {
			
			plikGracza.getParentFile().mkdirs();
			plikGracza.createNewFile();
		} catch (IOException e) {

			e.printStackTrace();
		}
		NationMain.log("Utworzono nowy plik Nation dla "  + player.getDisplayName());
	}
	ustawienia = YamlConfiguration.loadConfiguration(plikGracza);
	
	dodajGracza(player, ustawienia);
	}
	
	
	
	
	
	
	
	
	public static void dodajGracza(Player player, FileConfiguration conf) { 
		
		if(!GRACZE.containsKey(player.getDisplayName())) {
			
			GRACZE.put(player.getDisplayName(), new Statystyki(player.getDisplayName(), conf));
			
		}

	}

public static void usunGracza(String nick) {
	
	GRACZE.remove(nick);
}


	public static void log(String string) {
		
		log.info(string);
		
	}
	
	
	
}
