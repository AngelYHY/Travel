package multibean;

import java.util.List;

import beans.Image;

public class RecommInfoVo {

	RecommUser recommUser;
	List<GoodUser> goodUsers;
	List<Image> images;
	List<RecommJudgeUser> judgeUsers;
	public RecommInfoVo(RecommUser recommUser, List<GoodUser> goodUsers, List<Image> images,
			List<RecommJudgeUser> judgeUsers) {
		super();
		this.recommUser = recommUser;
		this.goodUsers = goodUsers;
		this.images = images;
		this.judgeUsers = judgeUsers;
	}
	public RecommUser getRecommUser() {
		return recommUser;
	}
	public void setRecommUser(RecommUser recommUser) {
		this.recommUser = recommUser;
	}
	public List<GoodUser> getGoodUsers() {
		return goodUsers;
	}
	public void setGoodUsers(List<GoodUser> goodUsers) {
		this.goodUsers = goodUsers;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public List<RecommJudgeUser> getJudgeUsers() {
		return judgeUsers;
	}
	public void setJudgeUsers(List<RecommJudgeUser> judgeUsers) {
		this.judgeUsers = judgeUsers;
	}
	
}
