package com.github.MySyns.Utils;

import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.data.User;

public class GMHolder {
	private static GroupManager gm;
	public GMHolder(GroupManager gm) {
		this.gm = gm;
	}
	public static void updatePlayerPms(String name,User user) {
		name = name.toLowerCase();
		gm.getWorldsHolder().getWorldDataByPlayerName(name).addUser(user);
	}
	public static User getUserByName(String name) {
		name = name.toLowerCase();
		return gm.getWorldsHolder().getWorldDataByPlayerName(name).getUser(name);
	}
}
