package edu.unca.jlmccask.Quest08;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;

public class QuestLogger {
	
	private Quest08 plugin;
	private Logger Log;
	
	public QuestLogger(Quest08 plugin){
		this.plugin = plugin;
		this.Log = Logger.getLogger("minecraft");
	}
	private String getFormattedMessage(String message){
		PluginDescriptionFile pdf = plugin.getDescription();
		return "[" + pdf.getName() + " V" + pdf.getVersion()+"]"+message;
	
	}
	public void info(String message){
		this.Log.info(this.getFormattedMessage(message));
	}
}
