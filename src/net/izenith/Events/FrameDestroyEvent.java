package net.izenith.Events;

import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import net.izenith.FrameAPI.FrameAction;

public class FrameDestroyEvent extends Event implements Cancellable{

	private static HandlerList handlers = new HandlerList();
	
	Player player;
	ItemFrame itemFrame;
	FrameAction action;
	EntityDamageByEntityEvent event;
	
	public FrameDestroyEvent(Player player, ItemFrame itemFrame, FrameAction action, EntityDamageByEntityEvent event){
		this.player = player;
		this.itemFrame = itemFrame;
		this.event = event;
		this.action = action;
	}
	
	public Player getPlayer() {
		return player;
	}

	public ItemFrame getItemFrame() {
		return itemFrame;
	}

	public FrameAction getAction(){
		return action;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
        return handlers;
    }
	
	@Override
	public boolean isCancelled() {
		return event.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel) {
		event.setCancelled(cancel);
	}

}
