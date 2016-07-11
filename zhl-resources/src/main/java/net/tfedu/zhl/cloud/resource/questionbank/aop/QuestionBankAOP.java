package net.tfedu.zhl.cloud.resource.questionbank.aop;


import net.tfedu.zhl.core.exception.CustomException;
import net.tfedu.zhl.helper.ResultJSON;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 面向切面编程
 * @author wangwr
 *
 */
@Aspect
@Component
public class QuestionBankAOP {

	
	@Pointcut("within(net.tfedu.zhl.cloud.resource.questionbank.controller.QuestionBankController)")
	public void  questionPointcut(){
	}
	
	

	@Around("questionPointcut()")
	@ResponseBody
	public Object doAround(ProceedingJoinPoint pjp){
		ResultQuestion result = new ResultQuestion();
		ResultJSON  json = null;
		try {
			
			json  = (ResultJSON)pjp.proceed();
		} catch (Throwable e) {
			CustomException ex = (CustomException)e;
			json = new ResultJSON(ex.getCode(), ex.getMessage(), "", "");
		}finally{
			result.setMessage("ok".equalsIgnoreCase(json.getCode())?"success":json.getCode());
			result.setResult(json.getData());
		}
		
		return result ;
	}
	
	
}
