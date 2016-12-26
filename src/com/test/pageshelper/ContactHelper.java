package com.test.pageshelper;

import com.test.pages.ContactPage;
import com.test.utils.SeleniumUtil;

public class ContactHelper {
	
	public static void SaveContact(SeleniumUtil seleniumUtil,String name,String mobile){
		seleniumUtil.type(ContactPage.Contact_name_input, name);
		seleniumUtil.type(ContactPage.Contact_mobile_input, mobile);
		seleniumUtil.click(ContactPage.Contact_save_button);
		seleniumUtil.pause(2000);
	}

}
