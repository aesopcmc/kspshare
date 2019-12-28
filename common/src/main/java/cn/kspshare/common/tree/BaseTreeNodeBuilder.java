package cn.kspshare.common.tree;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/28 10:29
 */
@FunctionalInterface
public interface BaseTreeNodeBuilder<PO, PK> {
    BaseTreeNode<PO, PK> getNode(PO po);
}
