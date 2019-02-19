package tsou.cn.databinding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;


public abstract class BaseActivity extends AppCompatActivity {
    private static List<BaseActivity> activities = new LinkedList<BaseActivity>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        synchronized (activities) {
            activities.add(this);
        }
    }

    protected void finishAllActivity() {
        List<BaseActivity> tempList;
        synchronized (activities) {
            tempList = new LinkedList<BaseActivity>(activities);
        }
        for (BaseActivity a : tempList) {
            a.finish();
        }

    }

    @Override
    protected void onDestroy() {
        activities.remove(this);
        try {
            System.gc();
        } catch (Exception e) {
        }
        super.onDestroy();
    }


}
