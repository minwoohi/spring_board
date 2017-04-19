package com.blog.naver.board.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.blog.naver.user.vo.UserVO;

public class BoardVO {
	
	private int boardId;
	private MultipartFile file;
	@NotEmpty(message="제목을 입력해야 합니다.")
	@Length(min=2, message="제목은 최소 2자 이상")
	private String subject;
	@NotEmpty(message="내용을 입력해야 합니다")
	private String content;
	private String writer;
	private int likeCount;
	private String writeDate;
	private String ip;
	private String post;
	private String realFileName;
	
	private UserVO userVO;
	
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getBoardId() {
		return boardId;
	}
	
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public UserVO getUserVO() { // Spring VO에서는 Null check 할 필요 없음~
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public String getRealFileName() {
		return realFileName;
	}

	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	
	
}
