package com.tarena.test;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.util.Config;

public class EntityContextTest {
	public static void mian(String[] args){
		Config config=new Config("client.propertise");
		EntityContext context=new EntityContext(config);
		System.out.println(context.getStr());
	}
}
