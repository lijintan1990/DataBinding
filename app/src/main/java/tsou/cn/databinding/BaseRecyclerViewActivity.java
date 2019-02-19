package tsou.cn.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public abstract class BaseRecyclerViewActivity<M extends ViewDataBinding> extends BaseActivity {
    protected View notDataView;
    protected View errorView;
    protected M binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        setEmptyAndErrorView(getRecyclerView(), R.mipmap.icon_empty, getString(R.string.the_server_did_not_return_data));
        initData(savedInstanceState);
        initListener();

    }
    public abstract int getLayoutId();
    public abstract RecyclerView getRecyclerView();

    protected abstract void initData(Bundle savedInstanceState);

    protected void initListener() {
    }

    protected void setEmptyAndErrorView(RecyclerView mRecyclerView, int emptyIcon, String emptyText) {
        notDataView = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) mRecyclerView.getParent(), false);
        ImageView empty_icon = (ImageView) notDataView.findViewById(R.id.iv_empty_icon);
        TextView empty_text = (TextView) notDataView.findViewById(R.id.tv_empty_no_data);
        empty_icon.setImageResource(emptyIcon);
        empty_text.setText(emptyText);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });
        errorView = getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) mRecyclerView.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });
    }

    protected void onRefresh() {
    }


}
