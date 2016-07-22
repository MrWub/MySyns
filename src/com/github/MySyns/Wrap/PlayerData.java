package com.github.MySyns.Wrap;

import org.bukkit.inventory.PlayerInventory;

public class PlayerData {
	private double money;
	private PlayerInventory inv;
	//private User pmsUser; ÆúÓÃ
	public PlayerData(double money,PlayerInventory inv) {
		this.money = money;
		this.inv = inv;
		//this.pmsUser = pmsUser;
	}
	public double getMoney() {
		return money;
	}
	public PlayerInventory getInv() {
		return inv;
	}

}
