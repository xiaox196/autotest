package com.test.pageshelper;

import org.apache.log4j.Logger;

import com.test.pages.HomePage;
import com.test.pages.WolaidaiLoginpage;
import com.test.utils.SeleniumUtil;

public class HomePageHelper {
	public static Logger logger=Logger.getLogger(HomePageHelper.class);
	
	public static void PersonalType(SeleniumUtil seleniumUtil){
		logger.info("执行了点击事件：HomePageHelper");
		seleniumUtil.click(HomePage.Personal_info_text);
	}
	
	public static void intoCompanyType(SeleniumUtil seleniumUtil){
		logger.info("执行了点击事件：HomePageHelper");
		seleniumUtil.click(HomePage.Company_info_text);
	}
	
	public static void intoContactType(SeleniumUtil seleniumUtil){
		logger.info("执行了点击事件：HomePageHelper");
		seleniumUtil.click(HomePage.Contacts_info_text);
	}
	
	public static void intoIdCardType(SeleniumUtil seleniumUtil){
		logger.info("执行了点击事件：HomePageHelper");
		seleniumUtil.click(HomePage.Photo_info_text);
	}
	
	public static void waitLoginPageLoad(SeleniumUtil seleniumUtil,int timeOut){
		logger.info("开始检查登录页面元素");
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.Home_info_button);
		logger.info("检查登录页面元素完毕");
	}
	
	public static void SaveInf(SeleniumUtil seleniumUtil){
		seleniumUtil.click(HomePage.Home_info_button);
	}
}
