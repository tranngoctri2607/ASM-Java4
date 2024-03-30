package com.poly.dao.impl;

import java.util.List;

import com.poly.dao.AbstractDao;
import com.poly.dao.HistoryDao;
import com.poly.entity.History;

public class HistoryDaoImpl extends AbstractDao<History> implements HistoryDao{

	@Override
	public List<History> findByUser(String username) {
		// TODO Auto-generated method stub
		String sql = "select o from History o where o.user.username = ?0 and o.video.isActive = 1"
				+ "order by o.viewDate desc";
		return super.fineMany(History.class, sql, username);
	}

	@Override
	public List<History> findByUserAndIsLiked(String username) {
		// TODO Auto-generated method stub
		String sql = "select o from History o where o.user.username = ?0 and o.isLiked = 1"
				+ "order by o.viewDate desc";
		return super.fineMany(History.class, sql, username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		// TODO Auto-generated method stub
		String sql = "select o from History o where o.user.userId = ?0 and o.video.videoId = ?1"
				+ "and o.video.isActive = 1";
		return super.findOne(History.class, sql, userId, videoId);
	}

	@Override
	public History create(History entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public History update(History entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
