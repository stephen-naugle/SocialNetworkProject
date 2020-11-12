package com.web.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Andrew Pearse Post model
 */

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@ManyToOne
	@JoinColumn(name="FK_user", referencedColumnName = "userId")
	private User author;
	
	private String title;
	private String body;
	private int likes;

	/**
	 * Creates a new post
	 * @param postId unique ID of the post
	 * @param author username of the author of the post
	 * @param title main header of the post
	 * @param body body of the post
	 */
	
	public Post(int postId, User author, String title, String body) {
		super();
		this.postId = postId;
		this.author = author;
		this.title = title;
		this.body = body;
	}

	public Post() {
		super();
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User owner) {
		this.author = owner;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", body=" + body + "]";
	}

}
