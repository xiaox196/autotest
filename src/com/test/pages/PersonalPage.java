package com.test.pages;

import org.openqa.selenium.By;

public class PersonalPage {
	public static final By Person_name_input=By.id("name");
	public static final By Persion_idcard_input=By.id("cnid");
	public static final By Person_name_text=By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div");
    public static final By Person_married_input=By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div[2]/div/select");
    public static final By Person_adrrs_text=By.xpath("//*[@id=\"app\"]/div/div[2]/div[4]/div[2]/div/div/div/div/div");
    public static final By Person_save_button=By.xpath("//*[@id=\"app\"]/div/div[3]/button");
    
    public static final By Person_addrs_text_one=By.linkText("深圳市");
    public static final By Person_addrs_text_two=By.linkText("广州市");
    public static final By Person_addrs_ok=By.linkText("完成");
}
