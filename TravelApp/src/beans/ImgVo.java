package beans;

import java.io.Serializable;

public class ImgVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int imgId;
	private String kind;
	private int kindId;
	private String imgAddr;
	private int imgWidth;
	private int imgHeight;
	
	private String userName;
	//没有用户的imgVo
	public ImgVo(int imgId, String kind, int kindId
			, String imgAddr,int imgWidth,int imgHeight) {
		super();
		this.imgId = imgId;
		this.kind = kind;
		this.kindId = kindId;
		this.imgAddr = imgAddr;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
	}
	//有用户名的imgVo
	public ImgVo(int imgId, String kind, int kindId, String imgAddr, int imgWidth, int imgHeight, String userName) {
		super();
		this.imgId = imgId;
		this.kind = kind;
		this.kindId = kindId;
		this.imgAddr = imgAddr;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.userName = userName;
	}
	
	
	public int getImgId() {
		return imgId;
	}
	
	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getKindId() {
		return kindId;
	}
	public void setKindId(int kindId) {
		this.kindId = kindId;
	}
	public String getImgAddr() {
		return imgAddr;
	}
	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getImgWidth() {
		return imgWidth;
	}
	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}
	public int getImgHeight() {
		return imgHeight;
	}
	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "ImgVo [imgId=" + imgId + ", kind=" + kind + ", kindId=" + kindId + ", imgAddr=" + imgAddr + "]";
	}
	
}
