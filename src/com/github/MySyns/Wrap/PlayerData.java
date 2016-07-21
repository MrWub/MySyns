package com.github.MySyns.Wrap;

import org.anjocaido.groupmanager.data.User;
import org.bukkit.inventory.PlayerInventory;

public class PlayerData {
	private int money;
	private PlayerInventory inv;
	private User pmsUser;
	public PlayerData(int money,PlayerInventory inv,User pmsUser) {
		this.money = money;
		this.inv = inv;
		this.pmsUser = pmsUser;
	}
}
