package DownloadFiles;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.fluent.Request;

public class BrokenLinks2Practise {

	public static void verifyLinks(String linkUrl) throws IOException
	{
		HttpURLConnection httpURLConnect = null;
		try
		{
			URL url = new URL(linkUrl);

			//Now we will be creating url connection and getting the response code
			 httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			System.out.println("Response code="+ httpURLConnect.getResponseCode());
			if(httpURLConnect.getResponseCode()>=400)
			{
				System.out.println("Response code="+ httpURLConnect.getResponseCode());
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
			}    

			//Fetching and Printing the response code obtained
			else{
				System.out.println("Response code="+ httpURLConnect.getResponseCode());
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
			}
			//************
			URL url1= new URL(linkUrl);
			httpURLConnect=(HttpURLConnection)url1.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			httpURLConnect.getResponseCode();
			
			
			
		}catch (Exception e) {
			System.out.println("Response code="+ httpURLConnect.getResponseCode());
		}
	}


		public static boolean checkResponse(String url){
			try {
			
	            int resp_code= Request.Get(url).execute().returnResponse().getStatusLine()
	                    .getStatusCode();
	            System.out.println("Respose code for URL "+ url +" is -> "+ resp_code);
	           if(resp_code == 200)
	        	   return true;
	           else
	        	   return false;
	        } catch (Exception e) {
	     	   return false;
	        }
		}


	public static void main(String[] args) throws IOException {
		System.out.println("strats");
//		verifyLinks("http://gmail.com");
//		verifyLinks("http://qtpselenium.com");
//		verifyLinks("http://qtpselenium123.com");

		//		
				System.out.println(checkResponse("http://gmail.com"));
				System.out.println(checkResponse("http://qtpselenium.com"));
		
		
				
				
		
		System.out.println("ends");
	}

}
