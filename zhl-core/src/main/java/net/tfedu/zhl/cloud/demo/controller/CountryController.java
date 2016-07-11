package net.tfedu.zhl.cloud.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tfedu.zhl.cloud.demo.entity.Country;
import net.tfedu.zhl.cloud.demo.service.CountryService;
import net.tfedu.zhl.cloud.utils.datatype.ArrayUtil;
import net.tfedu.zhl.helper.ResultJSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * Controller只处理三件事：
 * 1、接受参数；
 * 2、把参数传递给service
 * 3、返回结果。
 * 它没有处理业务逻辑的义务
 * @author Bruce
 *
 * 每个类级别的url应该不同，通过url地址，就能直接找到对应的controller
 *
 * controller不需要进行异常处理，所有的异常处理，都统一放到GlobalExceptionHandler里面去做。
 * 日志也是，除非自己需要记日志，否则其它的信息，全部由统一的日志来处理。
 * 
 */
@Controller
@RequestMapping("/country*")
public class CountryController {

    @Resource
    private CountryService countryService;

    /**
     * handler method 参数绑定常用的注解,我们根据他们处理的Request的不同内容部分分为四类：（主要讲解常用类型）
     * A、处理requet uri 部分（这里指uri template中variable，不含queryString部分）的注解： @PathVariable; 
     * B、处理request header部分的注解： @RequestHeader, @CookieValue; 
     * C、处理request body部分的注解：@RequestParam, @RequestBody; 
     * D、处理attribute类型是注解： @SessionAttributes, @ModelAttribute;
     */

    /**
     * 获取单个实体
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getById(@PathVariable int id) throws Exception {
        return countryService.get(id);
    }

    /**
     * 新建
     * 
     * @param request
     * @param response
     * @param entity
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResultJSON create(HttpServletRequest request, HttpServletResponse response, @RequestBody Country entity) throws Exception {
        return countryService.insert(entity);
    }

    /**
     * 批量新增
     * 
     * @param request
     * @param response
     * @param entity
     * @throws Exception
     */
    @RequestMapping(value = "/collection/", method = RequestMethod.POST)
    @ResponseBody
    public ResultJSON addArray(HttpServletRequest request, HttpServletResponse response, @RequestBody Country[] entity) throws Exception {
        return countryService.insert(ArrayUtil.arrayToList(entity));
    }

    /**
     * 更新
     * 
     * @param request
     * @param response
     * @param entity
     * @throws Exception
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultJSON update(HttpServletRequest request, HttpServletResponse response, @RequestBody Country entity) throws Exception {
        return countryService.update(entity);
    }

    /**
     * 删除
     * 
     * @param request
     * @param id
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultJSON delete(HttpServletRequest request, @RequestParam int id) {
        return countryService.delete(id);
    }

    /**
     * 分页查询
     * 
     * @param request
     * @param response
     * @param entity
     * @throws Exception
     */
    @RequestMapping(value = "/page/", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getPage(HttpServletRequest request, HttpServletResponse response) {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        return countryService.getPage(pageNum, pageSize);
    }

    /**
     * 自由查询
     * 
     * @param request
     * @param response
     * @param entity
     * @throws Exception
     */
    @RequestMapping(value = "/collection/", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON queryMaps(HttpServletRequest request, HttpServletResponse response) {
        return countryService.queryMaps();
    }

    /**
     * 自由查询
     * 
     * @param request
     * @param response
     * @param entity
     * @throws Exception
     */
    @RequestMapping(value = "/collection/property", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON queryIds(HttpServletRequest request, HttpServletResponse response) {
        return countryService.queryIds();
    }
}
