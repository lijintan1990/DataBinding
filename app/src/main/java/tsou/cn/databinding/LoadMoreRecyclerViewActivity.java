package tsou.cn.databinding;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import tsou.cn.databinding.adapter.LoadMoreAdapter;
import tsou.cn.databinding.bean.LoadMore;
import tsou.cn.databinding.databinding.ActivityLoadMoreRecyclerViewBinding;
import tsou.cn.databinding.view.CustomLoadMoreView;

public class LoadMoreRecyclerViewActivity extends BaseRecyclerViewActivity<ActivityLoadMoreRecyclerViewBinding>
        implements SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemClickListener {
    private LoadMoreAdapter adapter;
    private ArrayList<LoadMore> loadMores = new ArrayList<>();
    private int mLastIndex;
    private MyHandler myHandler;


    @Override
    public int getLayoutId() {
        return R.layout.activity_load_more_recycler_view;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return binding.recyclerView;
    }

    protected void initData(Bundle savedInstanceState) {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.swipeRefresh.setColorSchemeColors(Color.rgb(63, 81,
                181));
        adapter = new LoadMoreAdapter(loadMores);
        adapter.isFirstOnly(false);
        //慢慢淡进
        //adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        //慢慢放大进入
        //adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        //从下滑入
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        //从左滑入
        //adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        //从有滑入
        //adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        adapter.setLoadMoreView(new CustomLoadMoreView());
        binding.recyclerView.setAdapter(adapter);

        adapter.setEnableLoadMore(false);
        adapter.setEmptyView(R.layout.loading_view, (ViewGroup) binding.recyclerView.getParent());
        binding.swipeRefresh.setEnabled(false);
        myHandler = new MyHandler(this);
        fetchData(true);
    }

    @Override
    protected void initListener() {
        super.initListener();
        binding.swipeRefresh.setOnRefreshListener(this);
        adapter.setOnLoadMoreListener(this, binding.recyclerView);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onRefresh() {
        if (adapter.getData().isEmpty())
            adapter.setEmptyView(R.layout.loading_view, (ViewGroup) binding.recyclerView.getParent());
        adapter.setEnableLoadMore(false);
        fetchData(true);
    }

    @Override
    public void onLoadMoreRequested() {
        if (binding.swipeRefresh != null) {
            binding.swipeRefresh.setEnabled(false);
            mLastIndex++;
            fetchData(false);
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    private void fetchData(boolean isRefresh) {
        if (isRefresh) {
            mLastIndex = 1;
        }
        myHandler.sendEmptyMessageDelayed(0, 3000);

    }

    private static class MyHandler extends Handler {

        private WeakReference<LoadMoreRecyclerViewActivity> nowActivity;

        public MyHandler(LoadMoreRecyclerViewActivity nowActivity) {
            this.nowActivity = new WeakReference<LoadMoreRecyclerViewActivity>(nowActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LoadMoreRecyclerViewActivity activity = nowActivity.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            switch (msg.what) {
                case 0:
                    ArrayList<LoadMore> loadMores = activity.loadMores;
                    int mLastIndex = activity.mLastIndex;
                    ActivityLoadMoreRecyclerViewBinding binding = activity.binding;
                    LoadMoreAdapter adapter = activity.adapter;
                    ArrayList<LoadMore> loadMoresCurrent = new ArrayList<>();
                    if (mLastIndex == 1) {
                        loadMores.clear();
                        for (int i = 0; i < 10; i++) {
                            loadMoresCurrent.add(new LoadMore("晓果" + i, "https://unsplash.it/200/200?random&" + i));
                        }
                        loadMores.addAll(loadMoresCurrent);
                    } else {
                        for (int i = 11; i < 20; i++) {
                            loadMoresCurrent.add(new LoadMore("晓果" + i, "https://unsplash.it/200/200?random&" + i));
                        }
                    }
                    if (mLastIndex == 1) {
                        adapter.setNewData(loadMores);
                        binding.swipeRefresh.setEnabled(true);
                        binding.swipeRefresh.setRefreshing(false);
                        adapter.setEnableLoadMore(true);
                    } else {
                        if (loadMoresCurrent.size() == 0) {
                            adapter.loadMoreEnd();
                        } else {
                            adapter.addData(loadMoresCurrent);
                            adapter.loadMoreComplete();

                        }
                        binding.swipeRefresh.setEnabled(true);
                    }
                    break;
            }
        }
    }

}
