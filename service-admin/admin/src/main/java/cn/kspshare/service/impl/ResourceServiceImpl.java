package cn.kspshare.service.impl;

import cn.kspshare.common.id.IDGenerator;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.common.tree.BaseTreeNode;
import cn.kspshare.common.tree.TreeNodeUtils;
import cn.kspshare.domain.Resource;
import cn.kspshare.dto.KspResourceDto;
import cn.kspshare.mapper.ResourceDynamicSqlSupport;
import cn.kspshare.mapper.ResourceMapper;
import cn.kspshare.service.ResourceService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/24 17:51
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper kspResourceMapper;

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean add(KspResourceDto dto) {
        //验证资源编码唯一性
        Resource exist = this.findByCode(dto.getCode());
        if(exist!=null){
            return ResultBean.FAIL("该资源编码已被使用！");
        }

        //获取父编码link
        Long parentId = dto.getParentId();
        Optional<Resource> kspResource = kspResourceMapper.selectByPrimaryKey(parentId);

        AtomicReference<String> codeLink = new AtomicReference<>(null);
        kspResource.ifPresent(k-> codeLink.set(codeLink.get()+"-"+k.getCodeLink()));

        Resource domain = new Resource();
        BeanUtils.copyProperties(dto, domain);
        domain.setOid(IDGenerator.id());
        domain.setResourceType(dto.getResourceType().getCode());
        domain.setCodeLink(codeLink.get());
        kspResourceMapper.insertSelective(domain);

        return ResultBean.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = Exception.class )
    public ResultBean update(KspResourceDto dto) {
        Resource exist = this.findByCode(dto.getCode());
        if(exist!=null && !exist.getOid().equals(dto.getOid())) {
            return ResultBean.FAIL("该资源编码已被使用！");
        }

        Resource updateRecord = new Resource();
        BeanUtils.copyProperties(dto, updateRecord);
        updateRecord.setUpdateTime(LocalDateTime.now());
        kspResourceMapper.updateByPrimaryKeySelective(updateRecord);

        return ResultBean.SUCCESS();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBean delete(Long oid) {
        //删除子级
        Resource kspResource = kspResourceMapper.selectByPrimaryKey(oid).get();
        kspResourceMapper.delete(c->c.where(ResourceDynamicSqlSupport.codeLink, SqlBuilder.isLike(kspResource.getCode())));

        //删除自身
        kspResourceMapper.deleteByPrimaryKey(oid);

        //TODO 解除关系

        return ResultBean.SUCCESS();
    }

    @Override
    public ResultBean treeList() {
        List<Resource> list = kspResourceMapper.select(c -> c);
        List<BaseTreeNode<Resource, Long>> treeList =
                TreeNodeUtils.getTreeList(list, po -> new BaseTreeNode<>(po, po.getOid(), po.getParentId()));
        return ResultBean.SUCCESS(treeList);
    }

    @Override
    public Resource findByCode(String code) {
        Optional<Resource> kspResource = kspResourceMapper.selectOne(c ->
                c.where(ResourceDynamicSqlSupport.code, SqlBuilder.isEqualTo(code)));
        return kspResource.get();
    }

}
