package pages.serviceRequests.profile.pflupd;

import static com.codeborne.selenide.Selenide.$;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class ModifyBasicDetails extends BasePage {
	public ModifyBasicDetails(TestContext context) {
		super(context);
	}
	
	private SelenideElement txt_first_name = $(By.name("firstName"));
	private SelenideElement txt_last_name = $(By.name("lastName"));
	private SelenideElement rbut_male = $(By.name("113"));
	private SelenideElement rbut_female = $(By.name("115"));
	private SelenideElement txt_dob = $(By.name("dateOfBirth"));

	public void modify_Profile_details(String first,String last,String gender,String dob) {
		String firstname = first + " " + RandomStringUtils.randomAlphabetic(3);
		txt_first_name.val(firstname);
		ExtentCucumberAdapter.addTestStepLog("Entered First Name as " + firstname);
		String lastname = last + " " + RandomStringUtils.randomAlphabetic(3);
		txt_last_name.val(lastname);
		ExtentCucumberAdapter.addTestStepLog("Entered Last Name as " + lastname);	
		if(gender.equals("Male"))
		{
			rbut_male.click();
		}
		else
		{
			rbut_female.click();
		}
		txt_dob.val(dob);
		ExtentCucumberAdapter.addTestStepLog("Entered DOB as " + dob);	
		go_to_next_page();
		
	}
}