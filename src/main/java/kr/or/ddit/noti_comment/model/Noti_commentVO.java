package kr.or.ddit.noti_comment.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Noti_commentVO {
	private int id;         //댓글아이디
	private int notiId;     //게시글아이디
	
	@DateTimeFormat(pattern = "yyyy-MM-dd a hh:mm:ss")
	private Date reg_dt;    //작성일시
	private String userId;  //작성자
	private String content; //내용
	private String del_yn;	//삭제여부
	
	public Noti_commentVO() {}

	/**
	 * @param id 댓글 아이디
	 * @param notiId 댓글을 작성할 게시글 아이디
	 * @param userId 작성자 아이디
	 * @param content 댓글 내용
	 */
	public Noti_commentVO(int id, int notiId, String userId, String content) {
		super();
		this.id = id;
		this.notiId = notiId;
		this.userId = userId;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNotiId() {
		return notiId;
	}

	public void setNotiId(int notiId) {
		this.notiId = notiId;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	@Override
	public String toString() {
		return "Noti_commentVO [id=" + id + ", notiId=" + notiId + ", reg_dt="
				+ reg_dt + ", userId=" + userId + ", content=" + content
				+ ", del_yn=" + del_yn + "]";
	}
	
}                             
                              