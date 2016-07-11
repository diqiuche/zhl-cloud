package net.tfedu.zhl.cloud.resource.resourceList.entity;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 将pageIn封装为自定义的pagination
 * 
 * @author WeiCuicui
 *
 * @param <T>
 */
public class PageInfoToPagination<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  将pageIn封装为自定义的pagination
     * @param list
     * @return
     */
    public Pagination<T> transfer(List<T> list) {
        // 将查询结果封装到pagination
        PageInfo pageInfo = new PageInfo(list);

        Pagination<T> pagination = new Pagination<T>();

        // 设置当前页
        pagination.setPage(pageInfo.getPageNum());

        // 设置每页记录数
        pagination.setPerPage(pageInfo.getPageSize());

        // 设置总页数
        pagination.setTotal(pageInfo.getPages());

        // 设置总记录数目
        pagination.setTotalLines(pageInfo.getTotal());

        // 设置查询结果集
        pagination.setList(list);

        return pagination;

    }

}
