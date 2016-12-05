package multibean;

import java.io.Serializable;
import java.util.ArrayList;

import beans.Image;

public class FeaJudgeImageVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FeatureJudge judge;
	private ArrayList<Image> imgList;
	
	
	public FeaJudgeImageVo(FeatureJudge judge, ArrayList<Image> imgList) {
		super();
		this.judge = judge;
		this.imgList = imgList;
	}
	
	public FeatureJudge getJudge() {
		return judge;
	}
	public void setJudge(FeatureJudge judge) {
		this.judge = judge;
	}
	public ArrayList<Image> getImgList() {
		return imgList;
	}
	public void setImgList(ArrayList<Image> imgList) {
		this.imgList = imgList;
	}
	
}
