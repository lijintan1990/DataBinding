package tsou.cn.databinding.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import tsou.cn.databinding.R;
import tsou.cn.databinding.bean.LoadMore;
import tsou.cn.databinding.databinding.ItemLoadMoreBinding;
import tsou.cn.databinding.viewholder.MyBaseViewHolder;

/**
 * Created by Administrator on 2018/5/31 0031.
 */

public class LoadMoreAdapter extends BaseQuickAdapter<LoadMore, MyBaseViewHolder> {

    public LoadMoreAdapter(@Nullable List<LoadMore> data) {
        super(data);
    }

    @Override
    protected MyBaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        ItemLoadMoreBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.item_load_more, parent, false);
        return new MyBaseViewHolder(binding.getRoot());
    }

    @Override
    protected void convert(MyBaseViewHolder holder, LoadMore item) {
        ItemLoadMoreBinding binding = DataBindingUtil.getBinding(holder.itemView);
        binding.setLoadMore(item);
        binding.executePendingBindings();
    }
}
