package com.github.MySyns.Utils.Sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyResult {
	private ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	private ResultSet res;
	@SuppressWarnings("unchecked")
	public MyResult(ResultSet res) {
		this.res=res;
		list.add(new ArrayList<String>());
		try {
			if (res.isAfterLast()) return;
			ArrayList<String> tmp = new ArrayList<String>();
			while (res.next()) {
				tmp.clear();
				tmp.add(new String());
				for (int i=1; i<=res.getMetaData().getColumnCount(); i++) {
					tmp.add(res.getString(i));
				}
				list.add((ArrayList<String>)tmp.clone());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getRowCount() {
		return list.size()-1;
	}
	public ArrayList<ArrayList<String>> getAllTable() {
		return list;
	}
	public ArrayList<String> getRow(int row){
		return list.get(row);
	}
	
	private ResultSet getResultSet() {
		return res;
	}
}
