package Pojo;

import java.util.List;

public class PageBean<T> {
    private  int total;

    private List<T> list;

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }


    public PageBean(){}
    public PageBean(int total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
