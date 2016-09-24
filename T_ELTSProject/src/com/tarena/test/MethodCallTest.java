package com.tarena.test;

public class MethodCallTest {
	public static void main(String[] args) {
		Request req = new Request();
		req.setMethod("login");
		req.setParamTypes(new Class[] { int.class, String.class });
		req.setParams(new Object[] { 1, "1" });
		Object obj = new UserService();
		Response res = Utils.call(obj, req);
		if (res.isSuccess()) {
			System.out.println("欢迎" + res.getValue());
		}else{
			res.getException().printStackTrace();
		}
	}

	public static class UserService {// 内部类
		int index = 1;

		public String login(/*此处隐藏了一个this*/int id, String pwd) {
			if (id == 1 && pwd.equals("1")) {
				return "tom" + this.index++;
			}
			throw new RuntimeException("登录失败！");
		}

	}

}
