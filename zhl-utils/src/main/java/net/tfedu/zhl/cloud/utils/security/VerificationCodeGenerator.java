package net.tfedu.zhl.cloud.utils.security;



/**
 * 生成验证码v1.0
 * @author wangwr
 * 原理： 在指定取样的范围中 多次  随机获取字符，组成验证码
 *
 *
 */
public class VerificationCodeGenerator {
	
	/**
	 * 验证码的长度
	 */
	private static final int codeLength = 4;
	
	/**
	 * 所有候选组成验证码的字符
	 */
	private static final String[] selectChar = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T","U","V","W","X","Y","Z"};

	
	
	/**
	 * 获取验证码
	 * @return
	 */
	public static String getCode(){
		String code = "";
		 for(int i=0;i<codeLength;i++)   
	     {   //获取一个随机数
	      int charIndex = ((Double)Math.floor(Math.random()*34)).intValue(); 
	      code +=selectChar[charIndex];   
	     }  
		return  code ;
	}
	
	
}
