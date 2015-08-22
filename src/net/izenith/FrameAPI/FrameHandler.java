package net.izenith.FrameAPI;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import net.izenith.Events.FrameClickEvent;
import net.izenith.Events.FrameDestroyEvent;
import net.izenith.Events.FrameRotateEvent;

public class FrameHandler implements Listener {

	private HashMap<Integer, Frame> frames;

	protected FrameHandler() {
		frames = new HashMap<Integer, Frame>();
	}

	public Frame getFrame(int id) {
		if (frames.containsKey(id)) {
			return frames.get(id);
		}
		return null;
	}

	public int createFrame(ItemFrame itemFrame) {
		int i = 0;
		while (frames.containsKey(i))
			i++;
		frames.put(i, new Frame(itemFrame, i));
		return i;
	}

	public void removeFrame(int id) {
		if (frames.containsKey(id)) {
			frames.remove(id);
		}
	}

	public Frame getFrame(ItemFrame itemFrame) {
		for (Frame frame : frames.values()) {
			if (frame.getItemFrame().equals(itemFrame)) {
				return frame;
			}
		}
		return null;
	}

	public boolean isFrame(ItemFrame itemFrame) {
		for (Frame frame : frames.values()) {
			if (frame.getItemFrame().equals(itemFrame)) {
				return true;
			}
		}
		return false;
	}

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if (e.getEntityType().equals(EntityType.ITEM_FRAME)) {
			ItemFrame itemFrame = (ItemFrame) e.getEntity();
			if (isFrame(itemFrame)) {
				if (e.getDamager() instanceof Player) {
					Player player = (Player) e.getDamager();
					FrameAction action = FrameAction.LeftClick;
					Frame frame = getFrame(itemFrame);
					if (player.isSneaking()) {
						action = FrameAction.ShiftLeftClick;
					}
					FrameClickEvent event = new FrameClickEvent(frame, player, action);
					e.setCancelled(true);
					Bukkit.getPluginManager().callEvent(event);
				}
			} else {
				if (e.getDamager() instanceof Player) {
					Player player = (Player) e.getDamager();
					FrameAction action = FrameAction.LeftClick;
					if (player.isSneaking()) {
						action = FrameAction.ShiftLeftClick;
					}
					FrameDestroyEvent event = new FrameDestroyEvent(player,itemFrame,action,e);
					Bukkit.getPluginManager().callEvent(event);
				}
			}
		}
	}

	@EventHandler
	public void onEntityInteractEntity(PlayerInteractEntityEvent e) {
		ItemFrame itemFrame = (ItemFrame) e.getRightClicked();
		if (isFrame(itemFrame)) {
			if (e.getRightClicked().getType().equals(EntityType.ITEM_FRAME)) {
				Player player = e.getPlayer();
				FrameAction action = FrameAction.RightClick;
				Frame frame = getFrame(itemFrame);
				if (player.isSneaking()) {
					action = FrameAction.ShiftRightClick;
				}
				FrameClickEvent event = new FrameClickEvent(frame, player, action);
				e.setCancelled(true);
				Bukkit.getPluginManager().callEvent(event);
			}
		} else {
			Player player = e.getPlayer();
			FrameAction action = FrameAction.RightClick;
			if (player.isSneaking()) {
				action = FrameAction.ShiftRightClick;
			}
			FrameRotateEvent event = new FrameRotateEvent(player,itemFrame,action,e);
			Bukkit.getPluginManager().callEvent(event);
		}
	}

}
