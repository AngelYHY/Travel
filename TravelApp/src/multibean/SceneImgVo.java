package multibean;

import java.io.Serializable;
import java.util.ArrayList;

import beans.BannerSceneVo;
import beans.Image;

public class SceneImgVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BannerSceneVo sceneVo;
	private ArrayList<Image> imgList;
			
	public SceneImgVo(BannerSceneVo sceneVo, ArrayList<Image> imgList) {
		super();
		this.sceneVo = sceneVo;
		this.imgList = imgList;
	}
	
	
	public BannerSceneVo getSceneVo() {
		return sceneVo;
	}
	public void setSceneVo(BannerSceneVo sceneVo) {
		this.sceneVo = sceneVo;
	}
	public ArrayList<Image> getImgList() {
		return imgList;
	}
	public void setImgList(ArrayList<Image> imgList) {
		this.imgList = imgList;
	}			
}
