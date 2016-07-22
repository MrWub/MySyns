package com.github.MySyns.Utils;

import java.io.File;

import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.data.User;

public class GMHolder {
	private static GroupManager gm;
	public GMHolder(GroupManager gm) {
		this.gm = gm;
	}
	/*public static void updatePlayerPms(String name,User user) {
		name = name.toLowerCase();
		gm.getWorldsHolder().getWorldDataByPlayerName(name).addUser(user);
	}
	public static User getUserByName(String name) {
		name = name.toLowerCase();
		return gm.getWorldsHolder().getWorldDataByPlayerName(name).getUser(name);
	}*/
	public static String getUsersFilePath() {
		return gm.getWorldsHolder().getDefaultWorld().getUsersFile().getPath();
	}
	public static void loadUsersFile(String path) {
		gm.getWorldsHolder().getDefaultWorld().loadUsers(new File(path));
	}
	public static String getGroupsFilePath() {
		return gm.getWorldsHolder().getDefaultWorld().getGroupsFile().getPath();
	}
	public static void loadGroupsFile(String path) {
		gm.getWorldsHolder().getDefaultWorld().loadGroups(new File(path));
	}
}
