package exam;

import java.util.Arrays;
import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {
    private List<I> collection;
    private int itemsPerPage;

    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount(){
        return collection.size();
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        return (int)Math.ceil(collection.size()*1.0/itemsPerPage);
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex<0 || pageIndex > pageCount()){
            return -1;
        }
        if (pageIndex < pageCount()-1)
            return this.itemsPerPage;
        else if (pageIndex == pageCount()-1){
            return itemCount()-(pageCount()-1)*itemsPerPage;
        }else
            return -1;
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 1 || itemIndex>collection.size()){
            return -1;
        }
        return (int)Math.ceil(itemIndex*1.0/itemsPerPage)-1;
    }

    public static void main(String[] args) {
        PaginationHelper paginationHelper = new PaginationHelper(Arrays.asList('x', 'j', 't', 'u', 's', 'e'), 4);
        System.out.println(paginationHelper.pageCount());
        System.out.println(paginationHelper.pageIndex(2));
        System.out.println(paginationHelper.pageIndex(5));
        System.out.println(paginationHelper.pageIndex(20));
    }
}