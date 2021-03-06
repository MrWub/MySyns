package com.github.MySyns;

import org.bukkit.configuration.file.FileConfiguration;

public class SynsConfig {
	private static MySyns main;
	public static String host,port,dbName ,userName,passwd,groupFilePath,userFilePath,
	userTableName = "UserSynsData";
	
	private static FileConfiguration f;
	public SynsConfig(MySyns plugin) {
		SynsConfig.main = plugin;
	}
	public static boolean load() {
		try {
			main.saveDefaultConfig();
			main.reloadConfig();
			f=main.getConfig();
			
			host=f.getString("mysql.host");
			port=f.getString("mysql.port");
			dbName=f.getString("mysql.dbname");
			userName=f.getString("mysql.username");
			passwd=f.getString("mysql.passwd");
			groupFilePath=f.getString("gmsrc.groupsfilepath");
			userFilePath=f.getString("gmsrc.usersfilepath");
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
