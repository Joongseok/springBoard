package kr.or.ddit.notice.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class NoticeVO {

	private int notiId;	//게시글아이디
	private String userId;  //작성자
	private String title;   //제목
	private String content; //내용
	
	@DateTimeFormat(pattern = "yyyy-MM-dd a hh:mm:ss")
	private Date reg_dt;  //작성일시
	private int parentId;//부모 게시글아이디
	private int id;      //게시판아이디
	private String del_yn;  //삭제여부
	private int rn; // 삭제여부에 따른 게시글의 번호
	private int groupId; // 최상위 부모 컬럼 번호
	private int lv; 

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	// 기본 생성자
	public NoticeVO() {	}

	/**
	 * 게시글을 작성할때 사용하는 생성자
	 * @param notiId 게시글 아이디
	 * @param userId 작성자 아이디
	 * @param title 제목
	 * @param content 내용
	 * @param id 게시판 아이디
	 * @param groupId 최상위 부모 게시글 아이디
	 */
	public NoticeVO(int notiId, String userId, String title, String content,
			  int id, int groupId) {
		super();
		this.notiId = notiId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.id = id;
		this.groupId = groupId;
	}
	
	/**
	 * 게시글을 수정할때 사용하는 생성자
	 * @param notiId 게시글 아이디
	 * @param title 제목
	 * @param content 내용
	 */
	public NoticeVO(int notiId, String title, String content) {
		this.notiId = notiId;
		this.title = title;
		this.content = content;
	}

	/**
	 * 답글을 작성할때 사용하는 생성자
	 * @param createNotiId 새로 생길 게시글 아이디
	 * @param userId 작성자 아이디
	 * @param title 제목
	 * @param content 내용
	 * @param parentId 답글의 부모 게시글 아이디
	 * @param id 게시판 아이디
	 * @param groupId 최상위 부모 게시글 아이디
	 */
	public NoticeVO(int createNotiId, String userId, String title,
			String content, int parentId, int id, int groupId) {
		this.notiId = createNotiId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.parentId = parentId;
		this.id = id;
		this.groupId = groupId;
	}

	public int getNotiId() {
		return notiId;
	}

	public void setNotiId(int notiId) {
		this.notiId = notiId;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	@Override
	public String toString() {
		return "NoticeVO [notiId=" + notiId + ", userid=" + userId + ", title="
				+ title + ", content=" + content + ", reg_dt=" + reg_dt
				+ ", parentId=" + parentId + ", id=" + id + ", del_yn="
				+ del_yn + "]";
	}
	
}
