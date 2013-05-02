package pl.Oskar13.Nation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import pl.Oskar13.Nation.Rasy.RasaCzlowiek;
import pl.Oskar13.Nation.Rasy.RasaElf;
import pl.Oskar13.Nation.Rasy.RasaGuardian;
import pl.Oskar13.Nation.Rasy.RasaKrasnolud;

public class Statystyki {

  
   public String nick;
   public File folder;
   public  FileConfiguration ustawienia;
   public String rasa;
   

   private File ustawieniaFile = null;
	 public Statystyki(String nick, FileConfiguration ustawienia)  {
		 
	  
		 this.nick = nick;
		 folder = NationMain.instance.getDataFolder();
		 this.ustawienia = ustawienia;
		 reloadCustomConfig();
	 }

	 
	 
	 
	 
	 
	 public void reloadCustomConfig() {
		    if (ustawieniaFile == null) {
		   ustawieniaFile = new File("plugins" + File.separator + "Nation" + File.separator + "Gracze" + File.separator + nick + ".yml");
		    }
		    ustawienia = YamlConfiguration.loadConfiguration(ustawieniaFile);
		}
	 
	 
	 public FileConfiguration getConfig() {
		    if (ustawienia == null) {
		        this.reloadCustomConfig();
		    }
		    return ustawienia;
		}
	 
	 public void saveCustomConfig() {
		    if (ustawienia == null || ustawieniaFile == null) {
		    return;
		    }
		    try {
		        getConfig().save(ustawieniaFile);
		    } catch (IOException ex) {
		        NationMain.instance.getLogger().log(Level.SEVERE, "Nie da sie zapisac  " + ustawieniaFile, ex);
		    }
		}



	 
	public static Statystyki getData(String nick) {
		
		if(NationMain.GRACZE.containsKey(nick))
		return NationMain.GRACZE.get(nick);
		else
			return null;
		
	}
	 
	public void saveData() {
    NationMain.log("Save data!");
		if(ustawienia.isString("rasa")){ 
			
			ustawienia.set("rasa", this.rasa);
		}else{
			
			ustawienia.addDefault("rasa", rasa);
		}
		
		File plikGracza = new File("plugins" + File.separator + "Nation" + File.separator + "Gracze", nick + ".yml");
		try {
		    NationMain.log("zapisuje!");
			getConfig().save(plikGracza);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public RASY getKlasa() {
		
		
		if(ustawienia.getString("rasa") == null)
			return null;
		
		
		
		switch(ustawienia.getString("rasa")) {
		
		case "Czlowiek": return new RasaCzlowiek();
		case "Elf": return new RasaElf();
		case "Guardian": return new RasaGuardian();
		case "Krasnolud": return new RasaKrasnolud();
		
		
		
		}
		
		return null;
	}
	
	public void setRasa(String rasa) {
		this.rasa = rasa;
		saveData();
	}
	
	public String getRasa() {
		return ustawienia.getString("rasa");
	}

}
	
	 

