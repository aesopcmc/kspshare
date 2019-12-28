package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.common.tree.BaseTreeNode;
import cn.kspshare.common.tree.TreeNodeUtils;
import cn.kspshare.domain.KspResource;
import cn.kspshare.dto.KspResourceDto;
import cn.kspshare.mapper.KspResourceDynamicSqlSupport;
import cn.kspshare.mapper.KspResourceMapper;
import cn.kspshare.service.KspResourceService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/24 17:51
 */
@Service
public class KspResourceServiceImpl implements KspResourceService {
    @Autowired
    private KspResourceMapper kspResourceMapper;

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean add(KspResourceDto dto) {
        //验证资源编码唯一性
        KspResource exist = this.findByCode(dto.getCode());
        if(exist!=null){
            return ResultBean.FAIL("该资源编码已被使用！");
        }

        KspResource domain = new KspResource();
        BeanUtils.copyProperties(dto, domain);
        domain.setOid(IDGenerator.id());
        domain.setResourceType(dto.getResourceType().getCode());
        kspResourceMapper.insertSelective(domain);
        return ResultBean.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean update(KspResourceDto dto) {
        KspResource exist = this.findByCode(dto.getCode());
        if(exist!=null && !exist.getOid().equals(dto.getOid())) {
            return ResultBean.FAIL("该资源编码已被使用！");
        }

        KspResource updateRecord = new KspResource();
        BeanUtils.copyProperties(dto, updateRecord);
        updateRecord.setUpdateTime(LocalDateTime.now());
        kspResourceMapper.updateByPrimaryKeySelective(updateRecord);
        return ResultBean.SUCCESS();

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBean delete(Long oid) {
        //删除子级
        KspResource kspResource = kspResourceMapper.selectByPrimaryKey(oid).get();
        kspResourceMapper.delete(c->c.where(KspResourceDynamicSqlSupport.codeLink, SqlBuilder.isLike(kspResource.getCode())));

        //删除自身
        kspResourceMapper.deleteByPrimaryKey(oid);

        //TODO 解除关系

        return ResultBean.SUCCESS();
    }

    @Override
    public ResultBean treeList() {
        List<KspResource> list = kspResourceMapper.select(c -> c);
        List<BaseTreeNode<KspResource, Long>> treeList =
                TreeNodeUtils.getTreeList(list, po -> new BaseTreeNode<>(po, po.getOid(), po.getParentId()));
        return ResultBean.SUCCESS(treeList);
    }

    @Override
    public KspResource findByCode(String code) {
        Optional<KspResource> kspResource = kspResourceMapper.selectOne(c ->
                c.where(KspResourceDynamicSqlSupport.code, SqlBuilder.isEqualTo(code)));
        return kspResource.get();
    }


}
