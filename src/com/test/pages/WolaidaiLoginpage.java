package com.test.pages;

import org.openqa.selenium.By;

public class WolaidaiLoginpage {
	
	public static final By User_inf_text=By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[1]/div[2]/label");
	
	public static final By User_mobile_input=By.name("mobile");
	public static final By User_opt_input=By.name("otp");
	public static final By User_opt_button=By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/button");
	public static final By User_login_button=By.id("loginBtn");
}
