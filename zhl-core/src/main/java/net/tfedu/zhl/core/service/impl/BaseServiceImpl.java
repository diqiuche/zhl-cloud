package net.tfedu.zhl.core.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.tfedu.zhl.core.service.BaseService;
import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.helper.ResultJSON;

/**
 * 基础服务类
 * 
 * @author Bruce
 * @Autowired按byType自动注入，而@Resource默认按 byName自动注入罢了
 * @param <T>
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    protected static Logger log = LoggerFactory.getLogger("BaseServiceImpl");

    @Autowired
    CoreMapper<T> mapper;

    protected ResultJSON result;
    
    @Override
    public ResultJSON get(long id) {
        T data = mapper.selectByPrimaryKey(id);
        result = defaultSuccess(data);
        return result;
    }

    @Override
    public ResultJSON insert(T c) {
        int data = mapper.insert(c);
        result = defaultSuccess(data);
        return result;
    }

    @Override
    public ResultJSON delete(long id) {
        int data = mapper.deleteByPrimaryKey(id);
        result = defaultSuccess(data);
        return result;
    }

    /**
     * 更新部分属性
     */
    @Override
    public ResultJSON update(T c) {
        int data = mapper.updateByPrimaryKeySelective(c);
        result = defaultSuccess(data);
        return result;
    }

    /**
     * 批量插入
     */
    @Override
    public ResultJSON insert(List<T> datas) {
        int data = mapper.insertList(datas);
        result = defaultSuccess(data);
        return result;
    }

    /**
     * 分页查询
     */
    @Override
    public ResultJSON getPage(int pageNum, int pageSize) {
        // 用PageInfo对结果进行包装
        // Page插件必须放在查询语句之前紧挨的第一个位置
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id desc");
        // 这里不能放其它语句
        List<T> list = mapper.selectAll();
        PageInfo<T> page = new PageInfo<T>(list);
        result = defaultSuccess(page);
        return result;
    }

    /**
     * 按属性值查询
     */
    @Override
    public ResultJSON select(T c) {
        List<T> data = mapper.select(c);
        result = defaultSuccess(data);
        return result;
    }

    /**
     * 缺省成功处理
     * 
     * @param data
     * @return
     */
    protected ResultJSON defaultSuccess(Object data) {
        result = new ResultJSON("OK", "成功", data, "");
        return result;
    }

    /**
     * 缺省错误处理
     * 
     * @param data
     * @param e
     * @return
     */
    protected ResultJSON defaultError(Exception e) {
        result = new ResultJSON("unknown", e.getMessage(), e.toString(), "");
        log.error("出错了：" + e.getMessage());
        e.printStackTrace();
        return result;
    }

    /**
     * 获取当前的uuid
     * @param request
     * @return
     */
    public String getCurretUUId(HttpServletRequest request){
    	return  (String)request.getAttribute("currentUuId");
    }
    
    /**
     * 获取全部记录
     * @param c
     * @return
     */
	@Override
	public ResultJSON selectAll() {
		// TODO Auto-generated method stub
		List<T> data = mapper.selectAll();
        result = defaultSuccess(data);
        return result;
	}
    
    
    
    
}
