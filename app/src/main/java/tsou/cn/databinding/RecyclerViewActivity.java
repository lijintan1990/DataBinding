package tsou.cn.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import tsou.cn.databinding.adapter.StudentAdapter;
import tsou.cn.databinding.bean.Student;
import tsou.cn.databinding.databinding.ActivityRecyclerViewBinding;
import tsou.cn.databinding.viewmodel.RecyclerViewModel;

public class RecyclerViewActivity extends AppCompatActivity {
    private ActivityRecyclerViewBinding binding;
    private StudentAdapter adapter;
    private RecyclerViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentAdapter(this);
        binding.recyclerView.setAdapter(adapter);

        initData();
//        adapter.getItems().add(new Student("张三", 18));
//        adapter.getItems().add(new Student("李四", 28));
//        adapter.getItems().add(new Student("王五", 38));

        viewModel = new RecyclerViewModel(this, binding, adapter);
        //使用对象
        binding.setViewModel(viewModel);

    }

    private void initData() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("张三", 18));
        students.add(new Student("李四", 28));
        students.add(new Student("王五", 38));
        adapter.getItems().addAll(students);
    }

}
