package freestar.freelibrary.widge;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rey.material.widget.ProgressView;

import freestar.freelibrary.R;

/**
 * Created by freestar on 2017/1/7 0007.
 */

public class EmptyView extends FrameLayout implements View.OnClickListener {

    LinearLayout mHeaderContainer;
    ViewStub mLoadingViewStub;
    ViewStub mEmptyViewStub;
    ViewStub mErrorViewStub;
    private Context mContext;
    private Mode mState;
    private String mEmptySubTitle;

    EmptyViewHolder mEmptyViewHolder;
    ErrorViewHolder mErrorViewHolder;
    LoadViewHolder mLoadViewHolder;
    /**
     * 空标题
     */
    private String mEmptyMsg;
    private View mEmptyFrame;
    private View mErrorFrame;
    private View mLoadingFrame;
    private OnRefreshActionListener mRefreshActionListener;

    public EmptyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmptyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
        setEmptySubTitle(context.getString(R.string.common_empty_msg));
    }

    private EmptyView setEmptySubTitle(String msg) {
        mEmptySubTitle = msg;
        return this;
    }

    private void init() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_empty, this, true);
        mHeaderContainer = (LinearLayout) view.findViewById(R.id.header_container);
        mLoadingViewStub = (ViewStub) view.findViewById(R.id.loading_viewStub);
        mEmptyViewStub = (ViewStub) view.findViewById(R.id.empty_viewStub);
        mErrorViewStub = (ViewStub) view.findViewById(R.id.error_viewStub);
        this.mState = Mode.NONE;
    }

    public void showEmpty() {
        if (this.mState == Mode.EMPTY) {
            return;
        }
        if (mEmptyViewStub != null) {
            mEmptyFrame = mEmptyViewStub.inflate();
            mEmptyViewStub = null;
            mEmptyViewHolder = new EmptyViewHolder(mEmptyFrame);
        }
        if (!TextUtils.isEmpty(this.mEmptyMsg)) {
            mEmptyViewHolder.title.setText(mEmptyMsg);
            mEmptyViewHolder.title.setVisibility(VISIBLE);
        } else {
            this.mEmptyViewHolder.title.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(this.mEmptySubTitle)) {
            mEmptyViewHolder.subTitle.setText(mEmptyMsg);
            mEmptyViewHolder.subTitle.setVisibility(VISIBLE);
        } else {
            this.mEmptyViewHolder.subTitle.setVisibility(View.GONE);
        }
        mEmptyViewHolder.image.setImageResource(R.drawable.ic_action_nodata);
        mEmptyFrame.setVisibility(VISIBLE);
        mState = Mode.EMPTY;
    }

    public void hide() {
        if (mState == Mode.NONE) {
            return;
        }
        if (mEmptyViewHolder != null) {
            mEmptyViewHolder.image.setImageDrawable(null);
        }
        if (mErrorViewHolder != null) {
            mErrorViewHolder.mErrorImg.setImageDrawable(null);
            mErrorViewHolder.mErrorRefreshImg.clearAnimation();
        }
        setVisibility(GONE);
        mState = Mode.NONE;
    }

    public void showError(String msg) {
        if (mState == Mode.ERROR) {
            return;
        }
        if (mErrorViewStub != null) {
            mErrorFrame = mErrorViewStub.inflate();
            mErrorViewHolder = new ErrorViewHolder(mErrorFrame);
            mErrorViewStub = null;
        }
        if (!TextUtils.isEmpty(msg)) {
            mErrorViewHolder.mErrorTitle.setText(msg);
        }
        mErrorViewHolder.mErrorImg.setImageResource(R.drawable.ic_action_nodata);
        mErrorViewHolder.mErrorRefreshImg.clearAnimation();
        mErrorViewHolder.mErrorSubMsg.setOnClickListener(this);
        mErrorFrame.setVisibility(VISIBLE);
        if (mEmptyFrame != null) {
            mEmptyFrame.setVisibility(GONE);
            mEmptyViewHolder.image.setImageDrawable(null);
        }
        if (mLoadingFrame != null) {
            mLoadingFrame.setVisibility(GONE);
        }
        setVisibility(VISIBLE);
        mState = Mode.ERROR;
        showProgress();
    }

    public void showLoading() {
        if (mState == Mode.LOADING) {
            return;
        }
        if (mLoadingViewStub != null) {
            mLoadingFrame = mLoadingViewStub.inflate();
            mLoadViewHolder = new LoadViewHolder(this);
            mLoadingViewStub = null;
        }
        if (mEmptyFrame != null) {
            mEmptyFrame.setVisibility(GONE);
            mEmptyViewHolder.image.setImageDrawable(null);
        }
        if (mErrorFrame != null) {
            mErrorFrame.setVisibility(GONE);
            mErrorViewHolder.mErrorImg.setImageDrawable(null);
        }
        mLoadingFrame.setVisibility(VISIBLE);
        setVisibility(VISIBLE);
        mState = Mode.LOADING;
        mLoadViewHolder.mProgressPvCircular.start();
    }

    private void showProgress() {
        if (mState == Mode.LOAD) {
            return;
        }
        Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_rotate_repeat);
        localAnimation.setInterpolator(new LinearInterpolator());
        this.mErrorViewHolder.mErrorRefreshImg.startAnimation(localAnimation);
        this.mState = Mode.LOAD;
    }

    @Override
    public void onClick(View view) {
        if (mRefreshActionListener != null) {
            mRefreshActionListener.onRefreshActionClick();
        }
        hide();
    }

    public void setRefreshActionListener(OnRefreshActionListener refreshActionListener) {
        mRefreshActionListener = refreshActionListener;
    }

    public enum Mode {
        EMPTY, ERROR, LOAD, LOADING, NONE
    }

    static final class EmptyViewHolder {
        ImageView image;
        TextView subTitle;
        TextView title;

        public EmptyViewHolder(View v) {
            image = (ImageView) v.findViewById(R.id.img);
            subTitle = (TextView) v.findViewById(R.id.sub_title);
            title = (TextView) v.findViewById(R.id.title);
        }
    }

    static final class ErrorViewHolder {

        ImageView mErrorImg;
        TextView mErrorTitle;
        ImageView mErrorRefreshImg;
        TextView mErrorSubMsg;

        public ErrorViewHolder(View v) {
            mErrorImg = (ImageView) v.findViewById(R.id.error_img);
            mErrorTitle = (TextView) v.findViewById(R.id.error_title);
            mErrorRefreshImg = (ImageView) v.findViewById(R.id.error_refresh_img);
            mErrorSubMsg = (TextView) v.findViewById(R.id.error_sub_msg);
        }
    }

    static final class LoadViewHolder {

        ProgressView mProgressPvCircular;

        public LoadViewHolder(View v) {
            mProgressPvCircular = (ProgressView) v.findViewById(R.id.progress_pv_circular);
        }
    }

    public interface OnRefreshActionListener {
        void onRefreshActionClick();
    }
}
