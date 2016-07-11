package net.tfedu.zhl.cloud.resource.util;

import java.io.IOException;
import java.net.URLDecoder;

import org.springframework.util.SystemPropertyUtils;

import net.tfedu.zhl.fileservice.Base64;
import net.tfedu.zhl.fileservice.xxtea;

public class MD5BASE64Test {
	
	public static void main(String[] args) throws Exception {
		String  s= "lEIAwykXhZ%2BC7ajWL4oj%2FCTzzHssdaeV5bSgy6sJYRYN4yFtdc7CX1XHHvuVJYv6tDkXe3BqtWAqTsvqwnm4HMnT6ngNrO8KFSVUcyMyOcclA0XXQjZCE9koYcusiHNR";
		
		s = URLDecoder.decode(s, "utf-8");
		
		
		byte[] temp =  Base64.decode(s);
		
		temp =   xxtea.decrypt(temp, "9k8i78jug6hd93kjf84h".getBytes());
		
		System.out.println(new String(temp ));
	}

}
