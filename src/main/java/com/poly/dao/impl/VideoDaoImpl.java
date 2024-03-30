package com.poly.dao.impl;

import java.util.List;

import com.poly.dao.AbstractDao;
import com.poly.dao.VideoDao;
import com.poly.entity.Video;

public class VideoDaoImpl extends AbstractDao<Video> implements VideoDao{

	@Override
	public Video findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findByID(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		// TODO Auto-generated method stub
		String sql = "select o from Video o where o.href = ?0";
		return super.findOne(Video.class, sql, href);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findAll(int pageNumber, int PageSize) {
		// TODO Auto-generated method stub
		return super.findAll(Video.class, true, pageNumber, PageSize);
	}

	@Override
	public Video create(Video entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}

	@Override
	public Video update(Video entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public Video delete(Video entity) {
		// TODO Auto-generated method stub
		return super.delete(entity);
	}

}
