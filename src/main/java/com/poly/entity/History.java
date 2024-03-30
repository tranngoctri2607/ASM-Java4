package com.poly.entity;

import java.sql.*;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "history")
public class History {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userID", referencedColumnName = "id")//lien ket voi id trong user
	@JsonIgnoreProperties(value = {"application", "hibernateLazyInitializer"})
	private User user;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "videoID", referencedColumnName = "id")//lien ket voi id trong video
	@JsonIgnoreProperties(value = {"application", "hibernateLazyInitializer"})
	private Video video;

	@Column(name = "viewDate")
	@CreationTimestamp // lay thoi gian khi entity duoc them vao db
	private Timestamp viewDate;

	@Column(name = "isLiked")
	private Boolean isLiked;

	@Column(name = "likedDate")
	private Timestamp likedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Timestamp getViewDate() {
		return viewDate;
	}

	public void setViewDate(Timestamp viewDate) {
		this.viewDate = viewDate;
	}

	public Boolean getIsLiked() {
		return isLiked;
	}

	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}

	public Timestamp getLikedDate() {
		return likedDate;
	}

	public void setLikedDate(Timestamp likedDate) {
		this.likedDate = likedDate;
	}

}
