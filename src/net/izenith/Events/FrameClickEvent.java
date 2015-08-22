package net.izenith.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;

import net.izenith.FrameAPI.Frame;
import net.izenith.FrameAPI.FrameAction;

public class FrameClickEvent extends Event{

	private static HandlerList handlers = new HandlerList();

	Frame frame;
	Player player;
	FrameAction action;
	
	public FrameClickEvent(Frame frame, Player player, FrameAction action){
		this.frame = frame;
		this.player = player;
		this.action = action;
	}
	
	public Frame getFrame() {
		return frame;
	}

	public Player getPlayer() {
		return player;
	}

	public FrameAction getAction() {
		return action;
	}

	@Override
	public HandlerList getHandlers() {
		return null;
	}
	
	public static HandlerList getHandlerList() {
        return handlers;
    }
	
}
