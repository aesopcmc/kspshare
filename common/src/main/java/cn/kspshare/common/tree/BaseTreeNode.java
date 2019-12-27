package cn.kspshare.common.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务实体继承该类
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/25 17:23
 */
@Getter
@Setter
public class BaseTreeNode<PO,PK> {
    /**
     * 子Id
     */
    private PK id;
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

    public BaseTreeNode(PO targetPo, PK id, PK parentId) {
        this.id = id;
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
