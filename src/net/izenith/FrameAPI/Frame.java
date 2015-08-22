package net.izenith.FrameAPI;

import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Frame {

	ItemFrame itemFrame;
	int id;
	
	protected Frame(ItemFrame itemFrame, int id){
		this.itemFrame = itemFrame;
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
	public ItemFrame getItemFrame(){
		return itemFrame;
	}
	
	public void setName(String name){
		ItemStack item = itemFrame.getItem();
		ItemMeta iMeta = item.getItemMeta();
		iMeta.setDisplayName(name);
		item.setItemMeta(iMeta);
	}
	
	public void rotate(int amount){
		if(amount < 0){
			for(int i = 0; i < Math.abs(amount); i++){
				itemFrame.getRotation().rotateCounterClockwise();
			}
		} else {
			for(int i = 0; i < Math.abs(amount); i++){
				itemFrame.getRotation().rotateClockwise();
			}
		}
	}
	
}
