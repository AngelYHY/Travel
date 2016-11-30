package com.example.wo.travelt.widget;

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

import com.example.wo.travelt.R;
import com.rey.material.widget.ProgressView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jact on 2016/4/19.
 */
public class EmptyView extends FrameLayout implements View.OnClickListener {

    @Bind(R.id.empty_viewStub)
    ViewStub mEmptyViewStub;
    @Bind(R.id.error_viewStub)
    ViewStub mErrorViewStub;
    @Bind(R.id.loading_viewStub)
    ViewStub mLoadingViewStub;
    @Bind(R.id.header_container)
    LinearLayout mHeaderContainer;

    //private WeakReference<OnEmptyActionListener> mEmptyActionListener;
    private String mEmptyActionText;
    View mEmptyFrame;
    View mErrorFrame;
    View mLoadingFrame;
    //private WeakReference<OnEmptySubActionListener> mEmptySubActionListener;
    private String mEmptySubActionText;
    private String mEmptySubTitle;
    private String mEmptyTitle;
    EmptyViewHolder mEmptyViewHolder;
    ErrorViewHolder mErrorViewHolder;
    LoadViewHolder mLoadViewHolder;

    //private WeakReference<OnRefreshActionListener> mRefreshActionListener;
    private OnRefreshActionListener mRefreshActionListener;
    private Mode mState;

    public EmptyView(Context paramContext) {
        this(paramContext, null, 0);
    }

    public EmptyView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public EmptyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
        if (paramAttributeSet == null)
            return;
        //TypedArray type = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.EmptyView);
        //setEmptyTitle(paramContext.getString(R.string.common_empty_msg));
        setEmptySubTitle(paramContext.getString(R.string.common_empty_msg));
        //type.recycle();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_empty, this, true);
        ButterKnife.bind(this, this);
        this.mState = Mode.NONE;
    }

    private void showProgress() {
        if (this.mState == Mode.LOAD)
            return;
        Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_rotate_repeat);
        localAnimation.setInterpolator(new LinearInterpolator());
        this.mErrorViewHolder.refreshImg.startAnimation(localAnimation);
        this.mState = Mode.LOAD;
    }

    public void addHeaderView(View paramView) {
        this.mHeaderContainer.setVisibility(View.VISIBLE);
        this.mHeaderContainer.addView(paramView);
    }

    public void hide() {
        if (this.mState == Mode.NONE)
            return;
        if (this.mEmptyViewHolder != null)
            this.mEmptyViewHolder.image.setImageDrawable(null);
        if (this.mErrorViewHolder != null) {
            this.mErrorViewHolder.image.setImageDrawable(null);
            this.mErrorViewHolder.refreshImg.clearAnimation();
        }
        if (this.mLoadViewHolder != null) {

        }
        setVisibility(View.GONE);
        this.mState = Mode.NONE;
    }

    public void onClick(View paramView) {
        if (paramView.getId() == R.id.error_sub_msg) {
            /*if(this.mRefreshActionListener != null && this.mRefreshActionListener.get() != null){
                ((OnRefreshActionListener)this.mRefreshActionListener.get()).OnRefreshActionClick();
            }*/
            if (mRefreshActionListener != null) {
                mRefreshActionListener.OnRefreshActionClick();
            }
        }
        hide();
       /* if (paramView.getId() == R.id.title || paramView.getId() == R.id.sub_title){
            if(this.mEmptyActionListener != null && (this.mEmptyActionListener.get() != null)){
                ((OnEmptyActionListener)this.mEmptyActionListener.get()).onMainActionClick();
            }
            if(this.mEmptySubActionListener != null){
                ((OnEmptySubActionListener)this.mEmptySubActionListener.get()).onSubActionClick();

            }
        }*/
        /*if (paramView.getId() == R.id.action)
            if ((this.mEmptyActionListener != null) && (this.mEmptyActionListener.get() != null))
                ((OnEmptyActionListener)this.mEmptyActionListener.get()).onMainActionClick();
        do
        {
            do
            {
                return;
                if (paramView.getId() != 2131625080)
                    break label84;
            }
            while ((this.mEmptySubActionListener == null) || (this.mEmptySubActionListener.get() == null));
            ((OnEmptySubActionListener)this.mEmptySubActionListener.get()).onSubActionClick();
        }
        while ((paramView.getId() != 2131625081) || (this.mRefreshActionListener == null) || (this.mRefreshActionListener.get() == null));
        showProgress();
        this.mErrorViewHolder.errorTitle.setText(2131165590);
        ((OnRefreshListener)this.mRefreshActionListener.get()).onRefreshClick();*/
    }

    /*public EmptyView setEmptyAction(OnEmptyActionListener onEmptyActionListener) {
        if (onEmptyActionListener != null)
            this.mEmptyActionListener = new WeakReference<OnEmptyActionListener>(onEmptyActionListener);
        return this;
    }

    public EmptyView setEmptySubAction(OnEmptySubActionListener onEmptySubActionListener){
        if (onEmptySubActionListener != null)
            this.mEmptySubActionListener = new WeakReference<OnEmptySubActionListener>(onEmptySubActionListener);
        return this;
    }*/

    public EmptyView setEmptySubTitle(int paramInt) {
        return setEmptySubTitle(getResources().getString(paramInt));
    }

    public EmptyView setEmptySubTitle(String paramString) {
        this.mEmptySubTitle = paramString;
        return this;
    }

    public EmptyView setEmptyTitle(int paramInt) {
        return setEmptyTitle(getResources().getString(paramInt));
    }

    public EmptyView setEmptyTitle(String paramString) {
        this.mEmptyTitle = paramString;
        return this;
    }

    public EmptyView setRefreshActionListener(OnRefreshActionListener paramOnRefreshListener) {
        if (paramOnRefreshListener != null)
            //this.mRefreshActionListener = new WeakReference(paramOnRefreshListener);
            this.mRefreshActionListener = paramOnRefreshListener;
        return this;
    }

    public void showEmpty() {
        if (this.mState == Mode.EMPTY)
            return;
        if (this.mEmptyViewStub != null) {
            this.mEmptyFrame = this.mEmptyViewStub.inflate();
            this.mEmptyViewStub = null;
            this.mEmptyViewHolder = new EmptyViewHolder(this.mEmptyFrame);
        }
        if (!TextUtils.isEmpty(this.mEmptyTitle)) {
            this.mEmptyViewHolder.title.setText(this.mEmptyTitle);
            this.mEmptyViewHolder.title.setVisibility(View.VISIBLE);
            //this.mEmptyViewHolder.title.setOnClickListener(this);
        } else {
            this.mEmptyViewHolder.title.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(this.mEmptySubTitle)) {
            this.mEmptyViewHolder.subTitle.setText(this.mEmptySubTitle);
            this.mEmptyViewHolder.subTitle.setVisibility(View.VISIBLE);
            //this.mEmptyViewHolder.subTitle.setOnClickListener(this);
        } else {
            this.mEmptyViewHolder.subTitle.setVisibility(View.GONE);
        }
        /*if (TextUtils.isEmpty(this.mEmptyActionText)) {
                this.mEmptyViewHolder.actionText.setVisibility(View.VISIBLE);
                this.mEmptyViewHolder.actionText.setText(this.mEmptyActionText);
            }
            if (TextUtils.isEmpty(this.mEmptySubActionText)) {
                this.mEmptyViewHolder.subActionText.setText(this.mEmptySubActionText);
                this.mEmptyViewHolder.subActionText.setVisibility(View.VISIBLE);
            }*/
        while (true) {
            //this.mEmptyViewHolder.actionText.setOnClickListener(this);
            //this.mEmptyViewHolder.subActionText.setOnClickListener(this);
            this.mEmptyViewHolder.image.setImageResource(R.drawable.ic_anction_nodata);
            this.mEmptyFrame.setVisibility(View.VISIBLE);
            if (this.mErrorFrame != null) {
                this.mErrorFrame.setVisibility(View.GONE);
                this.mErrorViewHolder.image.setImageDrawable(null);
            }
            if (this.mLoadingFrame != null) {
                this.mLoadingFrame.setVisibility(View.GONE);
            }
            setVisibility(View.VISIBLE);
            this.mState = Mode.EMPTY;
            return;
        }
    }

    public void showError(int paramInt) {
        showError(getResources().getString(paramInt));
    }

    public void showError(String paramString) {
        if (this.mState == Mode.ERROR)
            return;
        if (this.mErrorViewStub != null) {
            this.mErrorFrame = this.mErrorViewStub.inflate();
            this.mErrorViewHolder = new ErrorViewHolder(this.mErrorFrame);
            this.mErrorViewStub = null;
        }
        if (!TextUtils.isEmpty(paramString))
            this.mErrorViewHolder.errorTitle.setText(paramString);
        this.mErrorViewHolder.image.setImageResource(R.drawable.ic_anction_nodata);
        this.mErrorViewHolder.refreshImg.clearAnimation();
        this.mErrorViewHolder.errorSubTitle.setOnClickListener(this);
        this.mErrorFrame.setVisibility(View.VISIBLE);
        if (this.mEmptyFrame != null) {
            this.mEmptyFrame.setVisibility(View.GONE);
            this.mEmptyViewHolder.image.setImageDrawable(null);
        }
        if (this.mLoadingFrame != null) {
            this.mLoadingFrame.setVisibility(View.GONE);
        }
        setVisibility(View.VISIBLE);
        this.mState = Mode.ERROR;

        showProgress();
    }

    public void showLoading() {
        if (this.mState == Mode.LOADING)
            return;
        if (this.mLoadingViewStub != null) {
            this.mLoadingFrame = this.mLoadingViewStub.inflate();
            this.mLoadViewHolder = new LoadViewHolder(this.mLoadingFrame);
            this.mLoadingViewStub = null;
        }
        if (this.mEmptyFrame != null) {
            this.mEmptyFrame.setVisibility(View.GONE);
            this.mEmptyViewHolder.image.setImageDrawable(null);
        }
        if (this.mErrorFrame != null) {
            this.mErrorFrame.setVisibility(View.GONE);
            this.mErrorViewHolder.image.setImageDrawable(null);
        }
        this.mLoadingFrame.setVisibility(View.VISIBLE);
        setVisibility(View.VISIBLE);
        this.mState = Mode.LOADING;

        this.mLoadViewHolder.loadprogress.start();
    }

    static final class EmptyViewHolder {
        @Bind(R.id.img)
        ImageView image;
        @Bind(R.id.sub_title)
        TextView subTitle;
        @Bind(R.id.title)
        TextView title;

        public EmptyViewHolder(View paramView) {
            ButterKnife.bind(this, paramView);
        }
    }

    static final class ErrorViewHolder {
        @Bind(R.id.error_title)
        TextView errorTitle;
        @Bind(R.id.error_img)
        ImageView image;
        @Bind(R.id.error_refresh_img)
        ImageView refreshImg;
        @Bind(R.id.error_sub_msg)
        TextView errorSubTitle;

        public ErrorViewHolder(View paramView) {
            ButterKnife.bind(this, paramView);
        }
    }

    static final class LoadViewHolder {
        @Bind(R.id.progress_pv_circular)
        ProgressView loadprogress;

        public LoadViewHolder(View paramView) {
            ButterKnife.bind(this, paramView);
        }
    }

    public enum Mode {
        EMPTY, ERROR, LOAD, LOADING, NONE
    }

    public interface OnRefreshActionListener {
        void OnRefreshActionClick();
    }

    /*public interface OnEmptyActionListener {
        void onMainActionClick();
    }

    public interface OnEmptySubActionListener {
        void onSubActionClick();
    }

    public interface OnRefreshListener {
        void onRefreshClick();
    }*/
}
