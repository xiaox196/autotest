package com.test.pages;

import org.openqa.selenium.By;

public class IdentityCardPage {
	public static final By IdCardPositive_text=By.xpath("//*[@id=\"id_front_proof\"]/input");
	public static final By IdCardReverse_text=By.xpath("//*[@id=\"id_back_proof\"]/input");
	public static final By IdCardInhand_text=By.xpath("//*[@id=\"id_handheld_proof\"]/input");
	public static final By Certify_text=By.xpath("//*[@id=\"employment_proof\"]/input");
	public static final By IdCard_save_button=By.xpath("//*[@id=\"h5_upload\"]/div[3]/button");
}
