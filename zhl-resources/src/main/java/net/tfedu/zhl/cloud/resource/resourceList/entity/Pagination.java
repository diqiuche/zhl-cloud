package net.tfedu.zhl.cloud.resource.resourceList.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询的结果集
 * 
 * @author WeiCuicui
 *
 */
public class Pagination<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    // 当前页
    private int page;
    // 每页的数量
    private int perPage;

    // 总记录数
    private long totalLines;
    // 总页数
    private int total;

    public long getTotalLines() {
        return totalLines;
    }

    public void setTotalLines(long totalLines) {
        this.totalLines = totalLines;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    // 结果集
    private List<T> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
