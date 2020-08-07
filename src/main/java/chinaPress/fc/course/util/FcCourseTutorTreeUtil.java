package chinaPress.fc.course.util;

import java.util.ArrayList;
import java.util.List;

import chinaPress.fc.course.vo.CourseTutorVo;
import net.sf.json.JSONArray;

public class FcCourseTutorTreeUtil {
	/**
	 * 使用递归方法建树
	 * 
	 * @param CourseTutorVos
	 * @return
	 */
	public static List<CourseTutorVo> buildByRecursive(List<CourseTutorVo> CourseTutorVos) {
		List<CourseTutorVo> trees = new ArrayList<CourseTutorVo>();
		for (CourseTutorVo CourseTutorVo : CourseTutorVos) {
			if (rootNode(CourseTutorVo, CourseTutorVos)) {
				trees.add(findChildren(CourseTutorVo, CourseTutorVos));
			}
		}
		return trees;
	}

	/**
	 * 使用递归方法建树 - JSON
	 * 
	 * @param CourseTutorVos
	 * @return
	 */
	public static String buildJSONByRecursive(List<CourseTutorVo> CourseTutorVos) {
		List<CourseTutorVo> trees = new ArrayList<CourseTutorVo>();
		for (CourseTutorVo CourseTutorVo : CourseTutorVos) {
			if (rootNode(CourseTutorVo, CourseTutorVos)) {
				trees.add(findChildren(CourseTutorVo, CourseTutorVos));
			}
		}
		JSONArray jsonArray = JSONArray.fromObject(trees);
		return jsonArray.toString();
	}

	/**
	 * 递归查找子节点
	 * 
	 * @param CourseTutorVos
	 * @return
	 */
	public static CourseTutorVo findChildren(CourseTutorVo CourseTutorVo,
			List<CourseTutorVo> CourseTutorVos) {
		// CourseTutorVo.setChildren(new ArrayList<CourseTutorVo>());
		for (CourseTutorVo it : CourseTutorVos) {
			if (CourseTutorVo.getId().equals(it.getpId())) {
				if (CourseTutorVo.getChildren() == null) {
					CourseTutorVo.setChildren(new ArrayList<CourseTutorVo>());
				}
				CourseTutorVo.getChildren().add(findChildren(it, CourseTutorVos));
			}
		}
		return CourseTutorVo;
	}

	/**
	 * 判断是否为根节点
	 * 
	 * @param nodes
	 * @param inNode
	 * @return
	 */
	private static boolean rootNode(CourseTutorVo node, List<CourseTutorVo> nodes) {
		boolean isRootNode = true;
		for (CourseTutorVo n : nodes) {
			if (node.getpId().equals(n.getId())) {
				isRootNode = false;
				break;
			}
		}
		return isRootNode;
	}
}
