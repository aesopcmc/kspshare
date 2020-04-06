package cn.kspshare.service;

import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.domain.KspBbsSession;
import cn.kspshare.utils.BasePage;

public interface BbsSessionService {
    /**
     * 添加
     * @param po
     * @return
     */
    ResultBean add(KspBbsSession po);

    /**
     * 修改
     * @param po
     * @return
     */
    ResultBean update(KspBbsSession po);

    /**
     * 删除
     * @param oid
     * @return
     */
    ResultBean delete(Long oid);

    /**
     * 查找所有
     * @return
     * @param param
     */
    ResultBean queryAll(BasePage param);

    /**
     * 根据名称查找
     * @param name
     * @return
     */
    KspBbsSession queryByName(String name);
}
