package chinaPress.fc.course.util;

import java.util.ArrayList;
import java.util.List;

import chinaPress.fc.course_section.vo.FcCourseSectionVo;
import net.sf.json.JSONArray;

public class FcCourseSectionTreeUtil {
	/**
	 * 两层循环实现建树
	 * 
	 * @param FcCourseSectionVos 传入的树节点列表
	 * @return
	 */
	public static List<FcCourseSectionVo> bulid(List<FcCourseSectionVo> FcCourseSectionVos) {
		List<FcCourseSectionVo> trees = new ArrayList<FcCourseSectionVo>();
		for (FcCourseSectionVo FcCourseSectionVo : FcCourseSectionVos) {
			if (rootNode(FcCourseSectionVo, FcCourseSectionVos)) {
				trees.add(FcCourseSectionVo);
			}
			for (FcCourseSectionVo it : FcCourseSectionVos) {
				if (it.getpId().equals(FcCourseSectionVo.getId())) {
					if (FcCourseSectionVo.getChildren() == null) {
						FcCourseSectionVo.setChildren(new ArrayList<FcCourseSectionVo>());
					}
					FcCourseSectionVo.getChildren().add(it);
				}
			}
		}
		return trees;
	}

	/**
	 * 两层循环实现建树 - JSON
	 * 
	 * @param FcCourseSectionVos 传入的树节点列表
	 * @return
	 */
	public static String bulidJSON(List<FcCourseSectionVo> FcCourseSectionVos) {
		List<FcCourseSectionVo> trees = new ArrayList<FcCourseSectionVo>();
		for (FcCourseSectionVo FcCourseSectionVo : FcCourseSectionVos) {
			if (rootNode(FcCourseSectionVo, FcCourseSectionVos)) {
				trees.add(FcCourseSectionVo);
			}
			for (FcCourseSectionVo it : FcCourseSectionVos) {
				if (it.getpId().equals(FcCourseSectionVo.getId())) {
					if (FcCourseSectionVo.getChildren() == null) {
						FcCourseSectionVo.setChildren(new ArrayList<FcCourseSectionVo>());
					}
					FcCourseSectionVo.getChildren().add(it);
				}
			}
		}
		JSONArray jsonArray = JSONArray.fromObject(trees);
		return jsonArray.toString();
	}

	/**
	 * 使用递归方法建树
	 * 
	 * @param FcCourseSectionVos
	 * @return
	 */
	public static List<FcCourseSectionVo> buildByRecursive(List<FcCourseSectionVo> FcCourseSectionVos) {
		List<FcCourseSectionVo> trees = new ArrayList<FcCourseSectionVo>();
		for (FcCourseSectionVo FcCourseSectionVo : FcCourseSectionVos) {
			if (rootNode(FcCourseSectionVo, FcCourseSectionVos)) {
				trees.add(findChildren(FcCourseSectionVo, FcCourseSectionVos));
			}
		}
		return trees;
	}

	/**
	 * 使用递归方法建树 - JSON
	 * 
	 * @param FcCourseSectionVos
	 * @return
	 */
	public static String buildJSONByRecursive(List<FcCourseSectionVo> FcCourseSectionVos) {
		List<FcCourseSectionVo> trees = new ArrayList<FcCourseSectionVo>();
		for (FcCourseSectionVo FcCourseSectionVo : FcCourseSectionVos) {
			if (rootNode(FcCourseSectionVo, FcCourseSectionVos)) {
				trees.add(findChildren(FcCourseSectionVo, FcCourseSectionVos));
			}
		}
		JSONArray jsonArray = JSONArray.fromObject(trees);
		return jsonArray.toString();
	}

	/**
	 * 递归查找子节点
	 * 
	 * @param FcCourseSectionVos
	 * @return
	 */
	public static FcCourseSectionVo findChildren(FcCourseSectionVo FcCourseSectionVo, List<FcCourseSectionVo> FcCourseSectionVos) {
		// FcCourseSectionVo.setChildren(new ArrayList<FcCourseSectionVo>());
		for (FcCourseSectionVo it : FcCourseSectionVos) {
			if (FcCourseSectionVo.getId().equals(it.getpId())) {
				if (FcCourseSectionVo.getChildren() == null) {
					FcCourseSectionVo.setChildren(new ArrayList<FcCourseSectionVo>());
				}
				FcCourseSectionVo.getChildren().add(findChildren(it, FcCourseSectionVos));
			}
		}
		return FcCourseSectionVo;
	}

	/**
	 * 判断是否为根节点
	 * 
	 * @param nodes
	 * @param inNode
	 * @return
	 */
	private static boolean rootNode(FcCourseSectionVo node, List<FcCourseSectionVo> nodes) {
		boolean isRootNode = true;
		for (FcCourseSectionVo n : nodes) {
			if (node.getpId().equals(n.getId())) {
				isRootNode = false;
				break;
			}
		}
		return isRootNode;
	}
}
