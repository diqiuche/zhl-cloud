package net.tfedu.zhl.cloud.resource.questionbank.aop;


/**
 * 题库格式的接口信息
 * @author wangwr
 * 
 * 格式举例
 * {"message":"success","result":[{"Name":"小学","Id":1},{"Name":"初中","Id":2},{"Name":"高中","Id":3}]}
 *	
 * 格式说明
 *	(1)message 消息头，代表请求查询成功或者失败
	(2)result  查询内容rowset 结果集
 */
public class ResultQuestion {

	
	/**
	 * 成功或者失败信息 
	 * success error
	 */
	String message ; 
	
	
	/**
	 * 查询内容结果
	 */
	Object result ;
	
	public ResultQuestion(){}
	
	public ResultQuestion(String message,Object result){
		this.message = message ; 
		this.result = result ;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Object getResult() {
		return result;
	}


	public void setResult(Object result) {
		this.result = result;
	} 
	
	
	public static ResultQuestion getSuccess(Object result){
		return new ResultQuestion("success", result);
	}
	

	public static ResultQuestion getError(){
		return new ResultQuestion("error", "");
	}
	
}
