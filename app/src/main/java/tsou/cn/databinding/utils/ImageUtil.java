package tsou.cn.databinding.utils;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class ImageUtil {
    @BindingAdapter({"url"})
    public static void loadImage(ImageView view, String url) {

        Glide.with(UIUtils.getContext()).load(url).into(view);
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, String text) {
        view.setText(text + "-追加的数据");
    }

    @BindingConversion
    public static String conversionString(String text) {
        return text + "-conversionString";
    }
}
