package tsou.cn.databinding.bean;

/**
 * Created by Administrator on 2018/5/31 0031.
 */

public class LoadMore {
    private String name;
    private String imaggUrl;

    public LoadMore(String name, String imaggUrl) {
        this.name = name;
        this.imaggUrl = imaggUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImaggUrl() {
        return imaggUrl;
    }

    public void setImaggUrl(String imaggUrl) {
        this.imaggUrl = imaggUrl;
    }
}
