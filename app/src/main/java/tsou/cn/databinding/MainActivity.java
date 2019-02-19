package tsou.cn.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import tsou.cn.databinding.bean.User;
import tsou.cn.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private User user;
    private ObservableArrayList<String> nums = new ObservableArrayList<>();
    private ObservableArrayMap<String, String> maps = new ObservableArrayMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User();
        user.setFristName("huang");
        user.setLastName("xiaoguo");
        user.setIsShow(true);
        user.setImageUrl("https://unsplash.it/200/200?random&10");

        //    第三步：使用  ActivityMainBinding
        /**
         * Android studio会根据layout文件自动生成一个默认的Binding类，
         * 类名是根据layout文件名生成的，
         * 并有"Binding"后缀结束。
         * 例如：activity_main.xml生成的Binding类为ActivityMainBinding
         *
         * 如果ActivityMainBinding，无法找到，可以先编译一下项目
         */
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        /**
         * 解决问题之：findviewbyId
         */
        // binding.firstName.setText(user.getFristName());
        // binding.lastName.setText(user.getLastName());

        //ObservableArrayList和ObservableArrayMap的使用：添加对象
        user.setNums(nums);
        user.setMaps(maps);
        /**
         * 将数据绑定到xml
         */
        //  方法一：
        //binding.setUser(user);
        //方法二：
        binding.setVariable(BR.user, user);

        //使用对象
        binding.setPresenter(new Presenter());

        //使用viewStub
        binding.viewStub.getViewStub().inflate();

        //ObservableArrayList和ObservableArrayMap的使用:更改数据
        addList();

    }

    private void addList() {

        nums.add("我是ObservableArrayList");

        maps.put("name", "我是ObservableArrayMap");

    }

    public class Presenter {
        //普通方法绑定
        public void onTextChanged(CharSequence s, int start, int before, int color) {
            user.setFristName(s.toString());
            user.setIsShow(!user.getIsShow().get());
//            binding.setUser(user);
        }

        //普通方法绑定
        public void onClick(View view) {
            Toast.makeText(MainActivity.this.getApplicationContext(), "点击了", Toast.LENGTH_LONG).show();
        }

        //监听器绑定，可以返回数据
        public void onClickListenerBinding(User user) {
            Toast.makeText(MainActivity.this.getApplicationContext(), user.getLastName(), Toast.LENGTH_LONG).show();
        }

        public void onGoToDynamicActivity(View view){
            startActivity(new Intent(view.getContext(),DynamicActivity.class));
        }
        public void onGoToRecyclerViewActivity(View view){
            startActivity(new Intent(view.getContext(),RecyclerViewActivity.class));
        }
        public void onGoToLoadMoreRecyclerViewActivity(View view){
            startActivity(new Intent(view.getContext(),LoadMoreRecyclerViewActivity.class));
        }
    }
}
