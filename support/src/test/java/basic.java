import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * @description: TODO
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-05-26 11:24
 */
public class basic {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
//        for(int i=0;i<900000;i++){
//            list.add(i+"whoseyourdaddy");
//        }
        
        System.out.println("2016-22-12".compareTo("2016-09-09"));
        try {
            Object object = JSONObject.parse("wrong text");
        }catch (Exception e){
            System.out.println("parse wrong!{}");
            System.out.println("parse wrong!{}"+e.getMessage());
        }
        System.out.println("come here");

    }
}
