package com.tarena.elts.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Config 读取系统的配置文件
 * */
public class Config {
	private Properties table = new Properties();

	public Config(){
	}
	
	public Config(String file) {
		try {
			table.load(new FileInputStream(file));
			//从输入流中读取属性列表（键和元素对）。
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int getInt(String key) {
		return Integer.parseInt(table.getProperty(key));
		/*getProperty(key):用指定的键在此属性列表中搜索属性。如果在
		此属性列表中未找到该键，则接着递归检查默认属性列表及其默认值。
		如果未找到属性，则此方法返回 null。 */
	}

	public String getString(String key){
		return table.getProperty(key);
	}
	
	public double getDouble(String key){
		return Double.parseDouble(table.getProperty(key));
	}
}
