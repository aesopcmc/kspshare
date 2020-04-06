package cn.kspshare.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页参数
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/19 9:41
 */
@Setter
@Getter
public class BasePage {
    /**
     * 当前页码，默认第1页
     */
    private int pageNum=1;
    /**
     * 每页显示数量，默认10条
     */
    private int pageSize=10;

}
