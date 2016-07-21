package com.github.MySyns.Utils;

import org.bukkit.OfflinePlayer;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import com.github.MySyns.MySyns;

public class VaultHolder {
	private static Permission pms;
	private static Chat chat;
	private static Economy economy;
	
	public VaultHolder() {
		chat = MySyns.setupVaultChat();
		pms = MySyns.setupVaultPms();
		economy = MySyns.setupVaultEco();
	}
	public static void setPlayerMoney(OfflinePlayer player,double money) {
		double has = economy.getBalance(player);
		if (has<money)
			economy.depositPlayer(player, money-has);
		else
			economy.withdrawPlayer(player, has-money);
	}
}
