package com.test.testcases.login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.test.base.BaseParpare;
import com.test.base.User;
import com.test.pageshelper.CompanyHelper;
import com.test.pageshelper.ContactHelper;
import com.test.pageshelper.HomePageHelper;
import com.test.pageshelper.IdentityCardHelper;
import com.test.pageshelper.PersonalHelper;
import com.test.pageshelper.WoLaiDaiLoginPageHelper;
import com.test.utils.IdCardGenerator;

public class WolaidaiLogin_001_Login_test extends BaseParpare {
	

	@Test
	public void Register() {
		// 用户信息
		User user = new User("18833333322", "888888", "张三", "", "球球大战星球", "自动化测试", "075588888877");
		IdCardGenerator g = new IdCardGenerator();
		user.setIdcard(g.generate());
		WoLaiDaiLoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
		WoLaiDaiLoginPageHelper.input(seleniumUtil, user.getUser(), user.getCode());
		WoLaiDaiLoginPageHelper.Login(seleniumUtil);
		
		//个人信息
		HomePageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
		HomePageHelper.PersonalType(seleniumUtil);
		PersonalHelper.inputUserInf(seleniumUtil, user);

		// 输入公司信息
		HomePageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
		HomePageHelper.intoCompanyType(seleniumUtil);
		CompanyHelper.inputCompanyInfo(seleniumUtil, user);
		
		//紧急联系人
		HomePageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
		HomePageHelper.intoContactType(seleniumUtil);
		ContactHelper.SaveContact(seleniumUtil, "马云", "18812345678");

		// 身份证信息
		HomePageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
		HomePageHelper.intoIdCardType(seleniumUtil);
		IdentityCardHelper.insertIdCard(seleniumUtil);
		
		HomePageHelper.SaveInf(seleniumUtil);
	}
}
