package cn.kspshare.common.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/25 17:23
 */
@Getter
@Setter
public final class BaseTreeNode<PO,PK> {
    /**
     * 子Id
     */
    private PK oid;
    /**
     * 父ID
     */
    private PK parentId;
    /**
     * 目标实体数据
     */
    private PO targetPo;
    /**
     * 子集合
     */
    private List<BaseTreeNode> child;

    /**
     * 构造树节点类
     * @param targetPo 实体类
     * @param oid 实体类主键
     * @param parentId 父主键
     */
    public BaseTreeNode(PO targetPo, PK oid, PK parentId) {
        this.oid = oid;
        this.parentId = parentId;
        this.targetPo = targetPo;
    }

    public void addChild(BaseTreeNode baseTreeNode) {
        if (this.child == null) {
            this.setChild(new ArrayList<>());
        }
        this.getChild().add(baseTreeNode);
    }
}
