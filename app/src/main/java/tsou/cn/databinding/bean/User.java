package tsou.cn.databinding.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;

import java.util.ArrayList;

import tsou.cn.databinding.BR;


/**
 * Created by Administrator on 2018/5/25 0025.
 */

//BaseObservable数据自动更新的使用

public class User extends BaseObservable {
    private String fristName;
    private String lastName;
    private String imageUrl;
    /**
     * 在单个或者比较少的数据需要监听时使用ObservableField
     * (ObservableBoolean,ObservableChar,ObservableInt,ObservableParcelable.....)
     */
    private ObservableField<Boolean> isShow = new ObservableField<>();

    public ObservableField<Boolean> getIsShow() {
        return isShow;
    }

    public void setIsShow(boolean show) {
        /**
         * 如果是Observable*类型设置数据需要使用set
         */
        this.isShow.set(show);
    }
    private ObservableArrayList<String> nums=new ObservableArrayList<>();
    private ObservableArrayMap<String,String> maps =new ObservableArrayMap<>();
    public ObservableArrayList<String> getNums() {
        return nums;
    }
    public void setNums(ObservableArrayList<String> nums) {
        this.nums=nums;
    }

    public ObservableArrayMap<String, String> getMaps() {
        return maps;
    }

    public void setMaps(ObservableArrayMap<String, String> maps) {
        this.maps = maps;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    @Bindable
    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
        notifyPropertyChanged(BR.fristName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
