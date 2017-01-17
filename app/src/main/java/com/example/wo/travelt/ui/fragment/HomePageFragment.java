package com.example.wo.travelt.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.wo.travelt.R;
import com.example.wo.travelt.base.BaseFragment;
import com.example.wo.travelt.bean.SceneImgVo;
import com.example.wo.travelt.view.IHomePageView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import javax.inject.Inject;

import butterknife.Bind;
import freestar.freelibrary.widge.recyclerview.XRecyclerView;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
public class HomePageFragment extends BaseFragment implements IHomePageView{

    @Inject


    @Bind(R.id.tv_city)
    TextView mTvCity;
    @Bind(R.id.tv_search)
    TextView mTvSearch;
    @Bind(R.id.recycler_view)
    XRecyclerView mRecyclerView;

    public HomePageFragment() {
    }

    @Override
    protected void initView() {
        initRV();
    }

    private void initRV() {
        View headView = LayoutInflater.from(mContext).inflate(R.layout.first_item_shouye, null);
        Banner banner = (Banner) headView.findViewById(R.id.banner);
        initBanner(banner);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));

    }

    private void initBanner(Banner banner) {
        String[] images = new String[]{
                "http://dimg05.c-ctrip.com/images/fd/tg/g1/M00/CA/CB/CghzflWw37CAZJoEABxWVuKE_5A196_R_1600_10000_Mtg_7.jpg",
                "http://dimg03.c-ctrip.com/images/fd/tg/g1/M03/7A/6A/CghzfVWws-yAcClPAAsjzh_k3OE586_R_1600_10000_Mtg_7.jpg",
                "http://dimg07.c-ctrip.com/images/fd/tg/g4/M0B/EF/CB/CggYHFbR4HeAQcyzAAY0e8u1mpE328_C_1600_1200_Mtg_7.jpg",
                "http://dimg03.c-ctrip.com/images/fd/tg/g4/M00/F1/72/CggYHlbhEgSAIb5TACFxYZycco4887_R_1600_10000_Mtg_7.jpg"
        };
        //将图片集合放到banner
        Log.e(TAG, "bannerLunBoPicture: BannerConfig.CIRCLE_INDICATOR = " + BannerConfig.CIRCLE_INDICATOR);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setDelayTime(5000);
        banner.setImages(images);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment1;
    }

    @Override
    public void receive(SceneImgVo result) {

    }
}
