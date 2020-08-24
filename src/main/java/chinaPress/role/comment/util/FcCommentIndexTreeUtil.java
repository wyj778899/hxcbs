package chinaPress.role.comment.util;

import java.util.ArrayList;
import java.util.List;

import chinaPress.role.comment.vo.FcCommentIndexListVo;
import net.sf.json.JSONArray;

public class FcCommentIndexTreeUtil {

	/**
	 * 使用递归方法建树
	 * 
	 * @param LoveCirclePostCommentVos
	 * @return
	 */
	public static List<FcCommentIndexListVo> buildByRecursive(List<FcCommentIndexListVo> LoveCirclePostCommentVos) {
		List<FcCommentIndexListVo> trees = new ArrayList<FcCommentIndexListVo>();
		for (FcCommentIndexListVo FcCommentIndexListVo : LoveCirclePostCommentVos) {
			if (rootNode(FcCommentIndexListVo, LoveCirclePostCommentVos)) {
				trees.add(findChildren(FcCommentIndexListVo, LoveCirclePostCommentVos));
			}
		}
		return trees;
	}

	/**
	 * 使用递归方法建树 - JSON
	 * 
	 * @param LoveCirclePostCommentVos
	 * @return
	 */
	public static String buildJSONByRecursive(List<FcCommentIndexListVo> LoveCirclePostCommentVos) {
		List<FcCommentIndexListVo> trees = new ArrayList<FcCommentIndexListVo>();
		for (FcCommentIndexListVo FcCommentIndexListVo : LoveCirclePostCommentVos) {
			if (rootNode(FcCommentIndexListVo, LoveCirclePostCommentVos)) {
				trees.add(findChildren(FcCommentIndexListVo, LoveCirclePostCommentVos));
			}
		}
		JSONArray jsonArray = JSONArray.fromObject(trees);
		return jsonArray.toString();
	}

	/**
	 * 递归查找子节点
	 * 
	 * @param LoveCirclePostCommentVos
	 * @return
	 */
	public static FcCommentIndexListVo findChildren(FcCommentIndexListVo FcCommentIndexListVo,
			List<FcCommentIndexListVo> LoveCirclePostCommentVos) {
		for (FcCommentIndexListVo it : LoveCirclePostCommentVos) {
			if (FcCommentIndexListVo.getId().equals(it.getpId())) {
				FcCommentIndexListVo.getChildren().add(findChildren(it, LoveCirclePostCommentVos));
			}
		}
		return FcCommentIndexListVo;
	}

	/**
	 * 判断是否为根节点
	 * 
	 * @param nodes
	 * @param inNode
	 * @return
	 */
	private static boolean rootNode(FcCommentIndexListVo node, List<FcCommentIndexListVo> nodes) {
		boolean isRootNode = true;
		for (FcCommentIndexListVo n : nodes) {
			if (node.getpId().equals(n.getId())) {
				isRootNode = false;
				break;
			}
		}
		return isRootNode;
	}
}
