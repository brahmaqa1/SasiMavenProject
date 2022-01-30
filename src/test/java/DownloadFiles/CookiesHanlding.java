package DownloadFiles;

import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CookiesHanlding {

	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver",  "D:\\SeleniumSoftwares\\Alldrivers\\chromedriver_win32V96\\chromedriver.exe");		//
	

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.udemy.com/");  
		
		// get cookies name . value...
		Set<Cookie> getCookies=	driver.manage().getCookies();
		
		// HW  get all cookies count ?
		
		
		// get val from set var
		
		for(Cookie  eachCookie : getCookies)			
		{
			// name
			String  cookieName  = eachCookie.getName();
						// value
			String cookieValue = eachCookie.getValue();
			
			System.out.println("cookieName="+cookieName + ",cookie Vlaue="+cookieValue);
			
			//   get path
					
			
			
			// HW  get expiry date 
			
			// HW get domain
			
			// Hw  is secured
			
			
		}

		
//		cookieName=ud_cache_campaign_code,cookie Vlaue=INDIANEWLEARNER
//				cookieName=ud_cache_brand,cookie Vlaue=INen_US
//				cookieName=ud_cache_price_country,cookie Vlaue=IN
//				cookieName=__cfruid,cookie Vlaue=356d013675de11ba976e3481a710e6cb21303547-1642782330
//				cookieName=ud_cache_language,cookie Vlaue=en
//				cookieName=ud_firstvisit,cookie Vlaue=2022-01-21T16:25:29.531997+00:00:1nAwjC:GRSyTDImAbYqOwsomVkp8rFgLAY
//				cookieName=__cf_bm,cookie Vlaue=SeoHpax91O5dYiJCUAVO6UXoRY3AOH7HxjEdSNufrzU-1642782335-0-AQ5IaxdW/Hfqvmy21cbJMJU5Ntb3+lHFI7gEmwNg2BnqQwf14wgavAHafbo9WONW2z19AwBNWE3+MTkj6lvz8KcZmLD8Vj5ZxgNqkRmcFNvCEgJjWz45bTL/5ZFcFekfGyjcVbaw0PW49LDSpAEs+c9TTGwpRjDQKqgeWYWfRxz/pzA5SR77PiQhGeTHx1Itqg==
//				cookieName=ud_cache_device,cookie Vlaue=None
//				cookieName=ud_rule_vars,cookie Vlaue=eJx9jcsOgyAQRX_FsG01A-IDvsWEDIiW1JR0QDfGf69J26Srbm_uOWdnGWn22Y9mCynkSLqFvpZe2oarWgL2dup652BE2Vtec6VdjPfgmS7YPrApUMpv1oyY_XDuAxMgRAm8FLzgrRaNFqpqRNu14gKgAQZ2PV8LnmiOq7uZTDhNwZkUV3LebEgB7fKxRZrxEdwPRP65-vS3WEMFkiulvsWDHS9-gUef:1nAwjC:jGstOZpOi9eN--zsIIgJNfMKPsM
//				cookieName=ud_cache_modern_browser,cookie Vlaue=1
//				cookieName=__udmy_2_v57r,cookie Vlaue=60834e4b519340a8bf78cc0da48b1319
//				cookieName=seen,cookie Vlaue=1
//				cookieName=ud_cache_marketplace_country,cookie Vlaue=IN
//				cookieName=ud_cache_logged_in,cookie Vlaue=0
//				cookieName=__udmy_1_a12z_c24t,cookie Vlaue=VGhlIGFuc3dlciB0byBsaWZlLCB0aGUgdW5pdmVyc2UsIGFuZCBldmVyeXRoaW5nIGlzIDQy
//				cookieName=ud_cache_user,cookie Vlaue=""
//				cookieName=evi,cookie Vlaue="3@qCbhFJJmdW7Hu6IlbdKjGbc61Ks7dqXv6YpdFkeE6l5iE1EOeeiy2Ui8jwcjp9fnkRg0llMxbpov1opyJNEGWmjoRiwRXemlVEATXYqzOYPQGq9sCyhrRE47VqnqKx8Lt9s="
//				cookieName=ud_cache_release,cookie Vlaue=414fcb435404edaed81f
//				cookieName=csrftoken,cookie Vlaue=9eEZ5VfIIBUc8c7zgxxuqvUCSpUzF863ZkfpUXZqSerGkKJ1CFzPFia7npwVMbwY
//				cookieName=ud_cache_version,cookie Vlaue=1

		//  deleet all cookies
		
		driver.manage().deleteAllCookies();
		getCookies=	driver.manage().getCookies();
		
		System.out.println("cookies cnt="+ getCookies.size());
		
		
		// deleet cookie
		driver.manage().deleteCookieNamed("ud_cache_version");
		getCookies= driver.manage().getCookies();
		System.out.println("get cnt= "+getCookies.size());// 20-1 =19 
		
		//add cookie
		Cookie ck = new Cookie("MyCookie", "Ramsita");
	
		driver.manage().addCookie(ck);
		
		getCookies= driver.manage().getCookies();
		System.out.println("get cnt= "+getCookies.size());// 21 after adding 
		
		System.out.println("ends here");
		

	}

}
