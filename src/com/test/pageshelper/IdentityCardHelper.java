package com.test.pageshelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.test.pages.IdentityCardPage;
import com.test.utils.SeleniumUtil;

public class IdentityCardHelper {
	
	private static Properties prop = new Properties();
	
	
	public static void insertIdCard(SeleniumUtil seleniumUtil){
		try {
			prop.load(new FileInputStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path=prop.getProperty("filepath");
		seleniumUtil.sendFileToWeb(IdentityCardPage.IdCardPositive_text, path);
		seleniumUtil.pause(200);
		seleniumUtil.sendFileToWeb(IdentityCardPage.IdCardReverse_text, path);
		seleniumUtil.pause(200);
		seleniumUtil.sendFileToWeb(IdentityCardPage.IdCardInhand_text, path);
		seleniumUtil.pause(1000);
		seleniumUtil.sendFileToWeb(IdentityCardPage.Certify_text, path);
		seleniumUtil.pause(1000);
		seleniumUtil.click(IdentityCardPage.IdCard_save_button);
		seleniumUtil.pause(200);
	}
}
