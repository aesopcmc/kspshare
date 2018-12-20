package cn.kspshare.selectUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

public class SelectBuilder {
    public static <T> WeekendSqls<T> getCustom(){
        return WeekendSqls.custom();
    }

    public static <T> Example getExample(WeekendSqls<T> custom, Class zlcass){
        Example.Builder builder = new Example.Builder(zlcass).andWhere(custom);
        return builder.build();
    }

}
