package cn.zjc;

import cn.zjc.exception.ServiceException;
import cn.zjc.utils.ServiceAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/9/21 10:28
 * @function
 */
public class TestScope {

    @Test
    public void Test1() {
        List<String> list = new ArrayList<>();
        try {
            ServiceAssert.notEmpty(list, "%s 's List is empty", "zjc");
            System.out.println("抛出异常之后的...................");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzz");
    }

    @Test
    public void Test2(){
        String s = " ";
        ServiceAssert.notEmpty(s,"%s 's is empty","zjc");
        ServiceAssert.notBlank(s,"%s 's is blank","zjc");
    }
}
