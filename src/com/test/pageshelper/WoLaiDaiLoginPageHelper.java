package com.test.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.test.pages.LoginPage;
import com.test.pages.WolaidaiLoginpage;
import com.test.utils.SeleniumUtil;

public class WoLaiDaiLoginPageHelper {
	
	public static Logger logger=Logger.getLogger(WoLaiDaiLoginPageHelper.class);
	
	public static void waitLoginPageLoad(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.pause(1000);
		logger.info("开始检查登录页面元素");
		seleniumUtil.waitForElementToLoad(timeOut, WolaidaiLoginpage.User_inf_text);
		logger.info("检查登录页面元素完毕");
	}
	
	public static void input(SeleniumUtil seleniumUtil,
			String username,String opt)
	{
		logger.info("输入元素："+username);
		seleniumUtil.type(WolaidaiLoginpage.User_mobile_input, username);
		seleniumUtil.pause(500);
		seleniumUtil.type(WolaidaiLoginpage.User_opt_input, opt);
	}
	
	public  static void Login(SeleniumUtil seleniumUtil){
		logger.info("点击操作");
		seleniumUtil.click(WolaidaiLoginpage.User_opt_button);
		seleniumUtil.pause(500);
		seleniumUtil.click(WolaidaiLoginpage.User_login_button);
	}
}
