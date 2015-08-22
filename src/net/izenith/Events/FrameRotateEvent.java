package net.izenith.Events;

import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import net.izenith.FrameAPI.FrameAction;

public class FrameRotateEvent extends Event implements Cancellable{

	private static HandlerList handlers = new HandlerList();
	
	Player player;
	ItemFrame itemFrame;
	PlayerInteractEntityEvent event;
	FrameAction action;
	
	public FrameRotateEvent(Player player, ItemFrame itemFrame, FrameAction action, PlayerInteractEntityEvent event){
		this.player = player;
		this.itemFrame = itemFrame;
		this.event = event;
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
