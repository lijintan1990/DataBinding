package tsou.cn.databinding.viewmodel;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;

import tsou.cn.databinding.adapter.StudentAdapter;
import tsou.cn.databinding.bean.Student;
import tsou.cn.databinding.databinding.ActivityRecyclerViewBinding;

/**
 * Created by Administrator on 2018/5/31 0031.
 */

public class RecyclerViewModel {
    private Context mContext;
    private ActivityRecyclerViewBinding mBinding;
    private StudentAdapter mAdapter;

    public RecyclerViewModel(Context context,
                             ActivityRecyclerViewBinding binding,
                             StudentAdapter adapter) {
        this.mContext = context;
        this.mBinding = binding;
        this.mAdapter = adapter;
    }

    public void addData(View view) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("新加1", 18));
        students.add(new Student("新加2", 28));
        students.add(new Student("新加3", 38));
        mAdapter.getItems().addAll(students);

    }

    public void deleteData(View view) {
        if (mAdapter.getItems().size() > 0)
            mAdapter.getItems().remove(0);
    }
}
