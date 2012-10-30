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

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Quest08EventListener implements Listener {

	private Quest08 plugin;

	public Quest08EventListener(Quest08 plugin) {
		this.plugin = plugin;
	}

	// This is just one possible event you can hook.
	// See http://jd.bukkit.org/apidocs/ for a full event list.

	// All event handlers must be marked with the @EventHandler annotation 
	// The method name does not matter, only the type of the event parameter
	// is used to distinguish what is handled.

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Bukkit.getServer().broadcastMessage("Player " + event.getPlayer().getName() + " placed " + event.getBlock().getType() + " at " + event.getBlock().getLocation());
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void playerMove(PlayerMoveEvent event){
		 final Player player = event.getPlayer();
		 if (player.getItemInHand().getType() == Material.TORCH && player.getLocation().getBlockX()%5 == 0){
			 player.getLocation().getBlock().setType(Material.TORCH);
	
		 }
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void stickGoBoom(BlockDamageEvent event){
		Player p = event.getPlayer();
		
		//Bukkit.getServer().broadcastMessage(p.toString());
		if(p.getItemInHand().getType() == Material.STICK){
			Player temp = p;
			 temp.setHealth(p.getHealth());
			p.getWorld().strikeLightning(event.getBlock().getLocation());
			p.setHealth(temp.getHealth() -1);
		} 
	}
}

