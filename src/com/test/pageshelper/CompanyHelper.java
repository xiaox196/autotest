package com.test.pageshelper;

import com.test.base.User;
import com.test.pages.CompanyPage;
import com.test.utils.SeleniumUtil;

public class CompanyHelper {
	
	public static void inputCompanyInfo(SeleniumUtil seleniumUtil,User user){
		seleniumUtil.type(CompanyPage.company_name_input, user.getCompany());
		seleniumUtil.click(CompanyPage.companyDate_info_input);
		seleniumUtil.click(CompanyPage.companydate_ok_button);
		seleniumUtil.pause(200);
		seleniumUtil.type(CompanyPage.company_phone_input, user.getMobile());
		seleniumUtil.click(CompanyPage.company_addres_text);
		seleniumUtil.click(CompanyPage.companydate_ok_button);
		seleniumUtil.pause(200);
		seleniumUtil.type(CompanyPage.company_addresdetail_text, user.getAdds());
		seleniumUtil.click(CompanyPage.company_save_button);
		seleniumUtil.pause(3000);
	}
}
