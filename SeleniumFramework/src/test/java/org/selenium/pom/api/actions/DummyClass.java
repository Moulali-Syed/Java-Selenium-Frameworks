package org.selenium.pom.api.actions;

import org.selenium.pom.objects.User;
import org.selenium.pom.utils.FakerUtils;

public class DummyClass {

	public static void main(String[] args) {
//		new SignUpApi().getAccount();
//		System.out.println(new SignUpApi().fetchRegisterNonceValueUsingGroovy());
//		System.out.println(new SignUpApi().fetchRegisterNonceValueUsingJSoup());
//	User user = new User().setUsername("demouser"+new FakerUtils().generateRandomNumber())
//			.setPassword("demouser")
//			.setEmail("demouser"+new FakerUtils().generateRandomNumber()+"@askomdch.com");
//	
//	SignUpApi signUpApi = new SignUpApi();
//	
//	System.out.println(signUpApi.register(user));
//	System.out.println(signUpApi.getCookies());
	
		CartApi cartApi = new CartApi();
		cartApi.addToCart(1215, 1);
		System.out.println(cartApi.getCookies());
	}
}
