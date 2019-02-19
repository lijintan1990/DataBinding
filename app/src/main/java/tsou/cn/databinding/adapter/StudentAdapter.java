package tsou.cn.databinding.adapter;

import android.content.Context;

import tsou.cn.databinding.R;
import tsou.cn.databinding.bean.Student;
import tsou.cn.databinding.databinding.ItemStudentBinding;

/**
 * Created by Administrator on 2018/5/31 0031.
 */

public class StudentAdapter extends BaseBindingAdapter<Student,ItemStudentBinding> {



    public StudentAdapter(Context context) {
        super(context);
    }
    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.item_student;
    }

    @Override
    protected void onBindItem(ItemStudentBinding binding, Student item) {
        binding.setModel(item);
        binding.executePendingBindings();
    }
}
