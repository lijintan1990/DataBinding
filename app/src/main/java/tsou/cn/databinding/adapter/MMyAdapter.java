package tsou.cn.databinding.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import tsou.cn.databinding.BR;
import tsou.cn.databinding.R;
import tsou.cn.databinding.databinding.ItemmBinding;

/**
 * Created by 黄家三少 on 2018/5/30.
 */

public class MMyAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private List<String> mlist;
    public View.OnClickListener itemClickListener;
    private ItemmBinding binding;

    public MMyAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        mlist = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            mlist.add(i, "item" + i);
        }
    }
    @Override
    public int getCount() {
        return mlist == null ? 0 : mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.itemm, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ItemmBinding) convertView.getTag();
        }
        binding.setVariable(BR.item, mlist.get(position));
        binding.setMyAdapter(this);
        return convertView;
    }
    public void setOnclickListener(View.OnClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
