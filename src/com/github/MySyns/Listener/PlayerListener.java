package com.github.MySyns.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.github.MySyns.MySyns;
import com.github.MySyns.SynsSender;
import com.github.MySyns.SynsWorker;

public class PlayerListener implements Listener {

	public PlayerListener(MySyns mySysn) {
		// TODO 自动生成的构造函数存根
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		SynsWorker.playerSyns(e.getPlayer().getName());
	}
	public void onPlayerQuit(PlayerQuitEvent e) {
		SynsSender.SysnPlayerToDatabase(e.getPlayer());
	}
}
