package com.test.pageshelper;

import com.test.base.User;
import com.test.pages.PersonalPage;
import com.test.utils.SeleniumUtil;

public class PersonalHelper {
	
	public static void inputUserInf(SeleniumUtil seleniumUtil,User user){
		seleniumUtil.type(PersonalPage.Person_name_input, user.getName());
		seleniumUtil.type(PersonalPage.Persion_idcard_input, user.getIdcard());
		
	    seleniumUtil.selectByIndex(PersonalPage.Person_married_input, 2);
		seleniumUtil.click(PersonalPage.Person_adrrs_text);
		seleniumUtil.pause(100);
		seleniumUtil.click(PersonalPage.Person_addrs_ok);
		seleniumUtil.click(PersonalPage.Person_save_button);
		seleniumUtil.pause(3000);
	}
}
