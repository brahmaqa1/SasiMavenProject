package DownloadFiles;

import org.apache.commons.codec.binary.Base64;

public class PasswordEncodingDecoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		  String orig = "temp@1234";
//
//	        //encoding  byte array into base 64
//	        byte[] encoded = Base64.encodeBase64(orig.getBytes()); 
//	       
//	      
//	        System.out.println("Original String: " + orig );
//	        System.out.println("Base64 Encoded String : " + new String(encoded));
//	      
//	        //decoding byte array into base64
//	        byte[] decoded = Base64.decodeBase64(encoded);      
//	        System.out.println("Base 64 Decoded  String : " + new String(decoded));
//		
////	        Original String: temp@1234
////	        Base64 Encoded String : dGVtcEAxMjM0
////	        Base 64 Decoded  String : temp@1234
	        
	     
		String origPWd= "password";
		
		// encode pwd 
	
		byte[]  encodeArr=	Base64.encodeBase64(origPWd.getBytes());
		String encodeString = new String ( encodeArr);
		System.out.println(" encodeString="+ encodeString);  // dGVtcEAxMjM0
		
		//  decode 		
		byte[]  decodeArr= Base64.decodeBase64(encodeArr);
		  String   decodeString =new String (decodeArr);
		  
		  System.out.println("decodeString="+decodeString);
		
//		Revision:
		  // encoding -- base64
//		  / decodeBase64
			
		  

	}

}
