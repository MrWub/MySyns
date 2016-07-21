package com.github.MySyns.Utils;

import org.bukkit.craftbukkit.libs.com.google.gson.Gson;

public class JsonCoder {
	public static String toJson(Object obj) {
		return new Gson().toJson(obj);
	}
	public static <T> T toObject(String json,Class<T> clazz) {
		return new Gson().fromJson(json, clazz);
	}
}
