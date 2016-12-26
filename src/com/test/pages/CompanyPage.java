package com.test.pages;

import org.openqa.selenium.By;

public class CompanyPage {
	public static final By company_name_input=By.id("company");
	public static final By companyDate_info_input=By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div/div/div/div");
	public static final By companydate_ok_button=By.linkText("完成");
	public static final By company_phone_input=By.xpath("//*[@id=\"telephone\"]");
	public static final By company_addresdetail_text=By.id("street");
	public static final By company_addres_text=By.xpath("//*[@id=\"app\"]/div/div[2]/div[4]/div[2]/div[1]/div/div/div/div");
    public static final By company_save_button=By.xpath("//*[@id=\"app\"]/div/div[3]/button");

}
