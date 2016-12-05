package beans;

import java.io.Serializable;
import java.util.ArrayList;

import multibean.GoodUser;
import multibean.ReleaseUser;

/**
 * Created by Administrator on 2016/8/20.
 */
public class RelSayContentVo implements Serializable{

    /**
	 * 
	 */
	//int releaseId; String relAccount; String relContent; String relTime;
	//int userId; String account; String userName; String headImg;
	private static final long serialVersionUID = 1L;
	
    private ReleaseUser releaseUser;
    private ArrayList<GoodUser> goodList;
    private ArrayList<Image> imgList;
    private ArrayList<RelComment> commentList;
    
    public RelSayContentVo(ReleaseUser releaseUser, ArrayList<GoodUser> goodList, ArrayList<Image> imgList,
			ArrayList<RelComment> commentList) {
		super();
		this.releaseUser = releaseUser;
		this.goodList = goodList;
		this.imgList = imgList;
		this.commentList = commentList;
	}
	
	public ReleaseUser getReleaseUser() {
		return releaseUser;
	}
	public void setReleaseUser(ReleaseUser releaseUser) {
		this.releaseUser = releaseUser;
	}
	public ArrayList<GoodUser> getGoodList() {
		return goodList;
	}
	public void setGoodList(ArrayList<GoodUser> goodList) {
		this.goodList = goodList;
	}
	public ArrayList<Image> getImgList() {
		return imgList;
	}
	public void setImgList(ArrayList<Image> imgList) {
		this.imgList = imgList;
	}
	public ArrayList<RelComment> getCommentList() {
		return commentList;
	}
	public void setCommentList(ArrayList<RelComment> commentList) {
		this.commentList = commentList;
	}

}
