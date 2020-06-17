package chinaPress.common.util;

import java.util.ArrayList;
import java.util.List;

import chinaPress.common.tree.model.TreeNode;
import net.sf.json.JSONArray;

public class TreeUtil {
	/**
	 * 两层循环实现建树
	 * 
	 * @param treeNodes 传入的树节点列表
	 * @return
	 */
	public static List<TreeNode> bulid(List<TreeNode> treeNodes) {
		List<TreeNode> trees = new ArrayList<TreeNode>();
		for (TreeNode treeNode : treeNodes) {
			if (rootNode(treeNode, treeNodes)) {
				trees.add(treeNode);
			}
			for (TreeNode it : treeNodes) {
				if (it.getpId().equals(treeNode.getId())) {
					if (treeNode.getChildren() == null) {
						treeNode.setChildren(new ArrayList<TreeNode>());
					}
					treeNode.getChildren().add(it);
				}
			}
		}
		return trees;
	}

	/**
	 * 两层循环实现建树 - JSON
	 * 
	 * @param treeNodes 传入的树节点列表
	 * @return
	 */
	public static String bulidJSON(List<TreeNode> treeNodes) {
		List<TreeNode> trees = new ArrayList<TreeNode>();
		for (TreeNode treeNode : treeNodes) {
			if (rootNode(treeNode, treeNodes)) {
				trees.add(treeNode);
			}
			for (TreeNode it : treeNodes) {
				if (it.getpId().equals(treeNode.getId())) {
					if (treeNode.getChildren() == null) {
						treeNode.setChildren(new ArrayList<TreeNode>());
					}
					treeNode.getChildren().add(it);
				}
			}
		}
		JSONArray jsonArray = JSONArray.fromObject(trees);
		return jsonArray.toString();
	}

	/**
	 * 使用递归方法建树
	 * 
	 * @param treeNodes
	 * @return
	 */
	public static List<TreeNode> buildByRecursive(List<TreeNode> treeNodes) {
		List<TreeNode> trees = new ArrayList<TreeNode>();
		for (TreeNode treeNode : treeNodes) {
			if (rootNode(treeNode, treeNodes)) {
				trees.add(findChildren(treeNode, treeNodes));
			}
		}
		return trees;
	}

	/**
	 * 使用递归方法建树 - JSON
	 * 
	 * @param treeNodes
	 * @return
	 */
	public static String buildJSONByRecursive(List<TreeNode> treeNodes) {
		List<TreeNode> trees = new ArrayList<TreeNode>();
		for (TreeNode treeNode : treeNodes) {
			if (rootNode(treeNode, treeNodes)) {
				trees.add(findChildren(treeNode, treeNodes));
			}
		}
		JSONArray jsonArray = JSONArray.fromObject(trees);
		return jsonArray.toString();
	}

	/**
	 * 递归查找子节点
	 * 
	 * @param treeNodes
	 * @return
	 */
	public static TreeNode findChildren(TreeNode treeNode, List<TreeNode> treeNodes) {
		// treeNode.setChildren(new ArrayList<TreeNode>());
		for (TreeNode it : treeNodes) {
			if (treeNode.getId().equals(it.getpId())) {
				if (treeNode.getChildren() == null) {
					treeNode.setChildren(new ArrayList<TreeNode>());
				}
				treeNode.getChildren().add(findChildren(it, treeNodes));
			}
		}
		return treeNode;
	}

	/**
	 * 判断是否为根节点
	 * 
	 * @param nodes
	 * @param inNode
	 * @return
	 */
	private static boolean rootNode(TreeNode node, List<TreeNode> nodes) {
		boolean isRootNode = true;
		for (TreeNode n : nodes) {
			if (node.getpId().equals(n.getId())) {
				isRootNode = false;
				break;
			}
		}
		return isRootNode;
	}
}
