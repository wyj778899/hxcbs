package chinaPress.fc.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.fc.book.dao.FcBookArchivesMapper;
import chinaPress.fc.book.model.FcBookArchives;
import chinaPress.fc.book.vo.FcBookArchivesManageListVo;
import chinaPress.fc.book_catalog.dao.FcBookCatalogMapper;
import chinaPress.fc.book_catalog.model.FcBookCatalog;
import chinaPress.fc.book_content.dao.FcBookContentMapper;
import chinaPress.fc.book_content.model.FcBookContent;

/**
 * 20200717 书籍添加功能
 * 
 * @author wyj
 *
 */
@Service
public class FcBookArchivesService {

	// 书籍
	@Autowired
	private FcBookArchivesMapper fcBookArchivesMapper;

	// 书籍目录
	@Autowired
	private FcBookCatalogMapper fcBookCatalogMapper;

	// 书籍内容
	@Autowired
	private FcBookContentMapper fcBookContentMapper;

	/**
	 * 添加书籍信息
	 * 
	 * @param fcBookArchives
	 * @return
	 */
	@Transactional
	public void addFcBookArchives(FcBookArchives fcBookArchives) {
		// 添加书籍
		fcBookArchivesMapper.insertSelective(fcBookArchives);
		// 获取刚刚添加证书的id
		Integer id = fcBookArchives.getId();
		// 添加书籍目录
		for (FcBookCatalog catalog : fcBookArchives.getCatalogs()) {
			// 避免空操作
			if (catalog.getCatalogPhoto() != null && catalog.getCatalogPhoto() != "") {
				catalog.setBookId(id);
				fcBookCatalogMapper.insertSelective(catalog);
			}
		}
		// 添加书籍内容
		for (FcBookContent content : fcBookArchives.getContents()) {
			// 避免空操作
			if (content.getContentPhoto() != null && content.getContentPhoto() != "") {
				content.setBookId(id);
				fcBookContentMapper.insertSelective(content);
			}
		}
	}

	/**
	 * 书籍更新操作 避免数据库多次访问，只要执行删除和添加操作，删除原有数据，添加更新数据
	 * 
	 * @param fcBookArchives
	 * @return
	 */
	@Transactional
	public void setFcBookArchives(FcBookArchives fcBookArchives) {
		Integer id = fcBookArchives.getId();
		// 更新书籍信息
		fcBookArchivesMapper.updateByPrimaryKeySelective(fcBookArchives);
		// 删除书籍内容
		fcBookContentMapper.deleteByBookId(id);
		// 删除书籍目录
		fcBookCatalogMapper.deleteByBookId(id);
		// 添加书籍目录
		for (FcBookCatalog catalog : fcBookArchives.getCatalogs()) {
			// 避免空操作
			if (catalog.getCatalogPhoto() != null && catalog.getCatalogPhoto() != "") {
				catalog.setBookId(id);
				fcBookCatalogMapper.insertSelective(catalog);
			}
		}
		// 添加书籍内容
		for (FcBookContent content : fcBookArchives.getContents()) {
			// 避免空操作
			if (content.getContentPhoto() != null && content.getContentPhoto() != "") {
				content.setBookId(id);
				fcBookContentMapper.insertSelective(content);
			}
		}
	}

	/**
	 * id查询书籍信息
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Result findBookInfos(Integer id) {
		List<FcBookArchives> list = fcBookArchivesMapper.selectBookInfos(id);
		if (list.size() > 0) {
			return new Result(1, "查询成功", list);
		} else {
			return new Result(0, "查询失败", "");
		}
	}

	/**
	 * 查询书籍档案个数
	 * 
	 * @author maguoliang
	 * @param name 书籍名称
	 * @return
	 */
	public int selectBookArchivesCount(String name) {
		return fcBookArchivesMapper.selectBookArchivesCount(name);
	}

	/**
	 * 查询书籍档案列表
	 * 
	 * @author maguoliang
	 * @param name       书籍名称
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条数据
	 * @return
	 */
	public List<FcBookArchivesManageListVo> selectBookArchivesList(String name, Integer pageNumber, Integer pageSize) {
		return fcBookArchivesMapper.selectBookArchivesList(name, pageNumber * pageSize - pageSize, pageSize);
	}
}
