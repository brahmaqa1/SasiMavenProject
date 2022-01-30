package DownloadFiles;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class BrokenLinks2Practise2 {

	
	public  static int  getStatuscodeusingHTTPURLConnection(String url) throws IOException
	{
		
		URL urlObj = new URL(url);
		
//		URLConnection  urlcon= (HttpURLConnection)urlObj.openConnection();
//		urlcon.connect();
//		urlcon.getre
		
		HttpURLConnection  httpURLConObj= (HttpURLConnection)urlObj.openConnection();
		
		httpURLConObj.connect();
		int httpStatuscode= httpURLConObj.getResponseCode();
		String respMsg= httpURLConObj.getResponseMessage();
		
		System.out.println("httpStatuscode="+httpStatuscode);
		System.out.println("respMsg="+respMsg);
			
		return httpStatuscode;	
	}


	public static int getStatusCode(String url) throws ClientProtocolException, IOException 
	{
		
		try
		{
			int statuscode=Request.Get(url).execute()
					.returnResponse().getStatusLine().getStatusCode();
			
			System.out.println("statuscode="+statuscode);			
					
			if(statuscode == 200)
			{
				System.out.println("url "+ url+" is not broken. and succefully return status code 200");
				return statuscode;
			}
			else
			{
				System.out.println("url "+ url+" is  broken link.Status code="+statuscode );
			}
			return statuscode;
			
			
		}
		
		catch(Exception e)
		{
			System.out.println("url "+ url+" is  broken link" );
		}
		return 0;
		
	}


		public static void main(String[] args) throws IOException {
			System.out.println("strats");

			int code= getStatusCode("https://www.google.com/");
			System.out.println("code="+code);
			
			code= getStatusCode("https://www.google123Invalid.com/");
			System.out.println("code="+code);
//			
//			Exception in thread "main" java.net.UnknownHostException: No such host is known (www.google123Invalid.com)
			
//			statuscode=200
//					url https://www.google.com/ is not broken. and succefully return status code 200
//					code=200
//					url https://www.google123Invalid.com/ is  broken link
//					code=0

			
			
			 code= getStatuscodeusingHTTPURLConnection("https://www.google.com/");
				System.out.println("code="+code);
				
				code= getStatuscodeusingHTTPURLConnection("https://www.google123Invalid.com/");
				System.out.println("code="+code);
			
			
			System.out.println("ends");
		}

	}
