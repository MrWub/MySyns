package com.github.MySyns.Wrap;

import org.anjocaido.groupmanager.data.User;
import org.bukkit.inventory.PlayerInventory;

public class PlayerData {
	private double money;
	private PlayerInventory inv;
	private User pmsUser;
	public PlayerData(double money,PlayerInventory inv,User pmsUser) {
		this.money = money;
		this.inv = inv;
		this.pmsUser = pmsUser;
	}
	public double getMoney() {
		return money;
	}
	public PlayerInventory getInv() {
		return inv;
	}
	public User getPmsUser() {
		return pmsUser;
	}

}
