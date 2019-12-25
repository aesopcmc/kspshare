package cn.kspshare.common.tree;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class BaseTreeNode<PO> {
    /**
     * 子Id
     */
    private Long id;
    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 子集合
     */
    private List<BaseTreeNode> child;

    /**
     * 目标实体
     */
    private PO targetPo;

    public void addChild(BaseTreeNode baseTreeNode) {
        if (this.child == null) {
            this.setChild(new ArrayList<>());
        }

        this.getChild().add(baseTreeNode);
    }
}
