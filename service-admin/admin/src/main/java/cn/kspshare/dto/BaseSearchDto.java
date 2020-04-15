package cn.kspshare.dto;

import cn.kspshare.utils.BasePage;
import lombok.Getter;
import lombok.Setter;

/**
 * 通用查询参数dto
 */
@Setter
@Getter
public class BaseSearchDto extends BasePage {
    private String searchText;
}
