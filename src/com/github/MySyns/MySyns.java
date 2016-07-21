package com.github.MySyns;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.anjocaido.groupmanager.GroupManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.MySyns.Listener.GMListener;
import com.github.MySyns.Listener.PlayerListener;
import com.github.MySyns.Utils.GMHolder;
import com.github.MySyns.Utils.VaultHolder;
import com.github.MySyns.Utils.Sql.SqlHolder;



public class MySyns extends JavaPlugin {	
	public PluginManager pm;
	@Override
	public void onEnable()  {
		getLogger().info("MySyns插件已被加载");
		getLogger().info("注册事件..");
		pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerListener(this), this);
		pm.registerEvents(new GMListener(this),this);
		
		getLogger().info("获取GroupManagerHook..");
		new GMHolder((GroupManager) pm.getPlugin("GroupManager"));
		
		getLogger().info("HOOK Vault..");
		new VaultHolder();
		
		getLogger().info("读取配置文件..");
		new SynsConfig(this);
		
		getLogger().info("连接数据库..");
		SqlHolder.init();
		
		getLogger().info("加载同步系统..");
		new SynsWorker(this);
	}
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args)  {
		return false;
	}

	
	public static Permission setupVaultPms() {
        RegisteredServiceProvider<Permission> permissionProvider = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) return permissionProvider.getProvider();
        else return null;
	}
	public static Chat setupVaultChat() {
        RegisteredServiceProvider<Chat> chatProvider = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) return chatProvider.getProvider();
        else return null;
	}
	public static Economy setupVaultEco() {
        RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) return economyProvider.getProvider();
        else return null;
	}

}
