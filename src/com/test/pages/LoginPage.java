package com.test.pages;

import java.awt.List;
import java.sql.SQLException;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;

import com.test.utils.DBUtil;

/**
 * @description 登录页面元素定位声明
 */
public class LoginPage {
	/** 用户名输入框 */
	public static final By LP_INPUT_USERNAME = By.name("username");

	/** 密码输入框 */
	public static final By LP_INPUT_PASSWORD = By.name("password");
	
	/** 用户名输入框 */
	public static final By LP_INPUT_CODE = By.name("otpCode");

	/** 确认 */
	public static final By LP_BUTTON_CONFIRM = By.xpath("//*[@id=\"CAPTCHA\"]/form/div[2]/div/button");

	/** 登录按钮 */
	public static final By LP_BUTTON_LOGIN = By.xpath("//*[@id=\"login\"]/form/div[2]/div/button");

	/** 登录错误信息
	 * //*[@id="login"]/form/div[2]/div/button
	 *  
	 *  */
	public static final By LP_TEXT_ERROR = By.xpath("//*[@color='red']");

	/** 登录选择服务器 */
	public static final By LP_TEXT_SELECT = By.xpath("/html/body/div[1]/div/div/div/div[3]/div/button");

	/** STATING选择服务器 */
	public static final By LP_TEXT_STATING = By.xpath("/html/body/div[1]/div/div/div/div[3]/div/ul/li[5]/a");

	//
	public static final By LP_TEXT_OK = By.xpath("/html/body/div[1]/div/div/div/div[3]/span/button");
	

	public  static String getCode(String sql, String mobile) {
		String code = null;
		try {
			DBUtil.getConnection();
			code = (String) DBUtil.queryMap(sql, mobile).get("authentication_token");
			code=code.substring(0, 6);
			System.out.println("验证码为："+code);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return code;
	}

	@Test
	public void testStart() {
		String sql = "SELECT authentication_token FROM admins  WHERE mobile=? LIMIT 10;";
		try {
			DBUtil.getConnection();
			getCode(sql, "18588210641");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
