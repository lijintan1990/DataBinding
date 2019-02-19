package tsou.cn.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import tsou.cn.databinding.adapter.MMyAdapter;
import tsou.cn.databinding.databinding.ActivityDynamicBinding;

public class DynamicActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDynamicBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dynamic);
        MMyAdapter adapter = new MMyAdapter(getBaseContext());
        adapter.setOnclickListener(this);
        binding.gridView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getBaseContext(), v.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
    }
}
