package kr.or.ddit.board.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardVO {
	private int id;         //게시판아이디
	private String userId;  //생성자
	private String name;    //게시판이름
	private String use_yn;  //사용여부
	
	@DateTimeFormat(pattern =  "yyyy-MM-dd")
	private Date reg_dt;	//생성일시
	
	// 기본 생성자
	public BoardVO() {}
	
	// 생성용
	/**
	 * @param id 게시판 아이디
	 * @param userId 사용자 아이디
	 * @param name 게시판 이름
	 * @param use_yn 사용여부
	 */
	public BoardVO(int id, String userId, String name, String use_yn) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.use_yn = use_yn;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", userId=" + userId + ", name=" + name
				+ ", use_yn=" + use_yn + ", reg_dt=" + reg_dt + "]";
	}
}
