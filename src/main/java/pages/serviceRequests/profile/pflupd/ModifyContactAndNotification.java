package pages.serviceRequests.profile.pflupd;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class ModifyContactAndNotification extends BasePage {
	public ModifyContactAndNotification(TestContext context) {
		super(context);
	}
	

	private SelenideElement lst_preferred_medium = $(By.xpath("//div[2]/div[2]/div/div/div/div"));
	private SelenideElement lst_notification_email = $(By.xpath("//li[contains(.,'Email')]"));
	private SelenideElement txt_notification_email = $(By.name("email"));
	private SelenideElement txt_contact_num = $(By.name("contactNumber0"));
	
	
	public void modify_profile_notification_details(String email,String contact) {
		lst_preferred_medium.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		if(txt_notification_email.exists())
		{
			txt_notification_email.val(email);
			ExtentCucumberAdapter.addTestStepLog("Entered Notification Email as " + email);	
		}
		else
		{
			lst_preferred_medium.click();
			lst_notification_email.click();
			lst_preferred_medium.click();
			ExtentCucumberAdapter.addTestStepLog("Selected Notification Preferred Medium as Email");
			txt_notification_email.val(email);
			ExtentCucumberAdapter.addTestStepLog("Entered Notification Email as " + email);
		}
		txt_contact_num.val(contact);
		ExtentCucumberAdapter.addTestStepLog("Entered contact number as " + contact);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
		go_to_next_page();
		
	}
}