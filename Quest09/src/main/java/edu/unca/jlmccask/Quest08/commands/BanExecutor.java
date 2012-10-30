package edu.unca.jlmccask.Quest08.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import edu.unca.jlmccask.Quest08.Quest08;

public class BanExecutor implements CommandExecutor {

	private Quest08 plugin;

	public BanExecutor(Quest08 plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String args[]){
		if(args.length != 1){
			sender.sendMessage(ChatColor.RED + "Usage: /band <player_name>");
			return true;
		}
		
		if(sender.isOp() == false){
			sender.sendMessage(ChatColor.RED + "you cant do that");
			return true;
		}
		
		Player ban = plugin.getServer().getPlayer(args[0]);
		
		plugin.bannedPlayers.add(args[0]);
		
		if( ban != null){
			ban.kickPlayer("You have been banned");
		}
		
		sender.sendMessage(ChatColor.GREEN + args[0] + "has been banned");
		
		return true;
	}
}
