package edu.unca.jlmccask.Quest08;

/*
    This file is part of Quest08

    Foobar is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.File;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import edu.unca.jlmccask.Quest08.commands.BanExecutor;
import edu.unca.jlmccask.Quest08.util.ListStore;


public class Quest08 extends JavaPlugin {

	
	
	//ClassListeners
	private final Quest08CommandExecutor commandExecutor = new Quest08CommandExecutor(this);
	private final Quest08EventListener eventListener = new Quest08EventListener(this);
	//ClassListeners
	
	public QuestLogger log;
	public ListStore bannedPlayers;
	public void onDisable() {
		// add any code you want to be executed when your plugin is disabled
	this.bannedPlayers.save();
	}

	public void onEnable() { 
		this.log = new QuestLogger(this);
		
		String pluginFolder = this.getDataFolder().getAbsolutePath();
		
		(new File(pluginFolder)).mkdirs();
		
		this.bannedPlayers = new ListStore(new File(pluginFolder + File.separator + "banned_players.txt"));
		this.bannedPlayers.load();
		
		PluginManager pm = this.getServer().getPluginManager();

		this.getCommand("command").setExecutor(commandExecutor);
		this.getCommand("ban").setExecutor(new BanExecutor(this));

		this.getServer().getPluginManager().registerEvents(new PlayerLoginListner(this), this);
		// you can register multiple classes to handle events if you want
		// just call pm.registerEvents() on an instance of each class
		pm.registerEvents(eventListener, this);

		// do any other initialisation you need here...
	}
}
