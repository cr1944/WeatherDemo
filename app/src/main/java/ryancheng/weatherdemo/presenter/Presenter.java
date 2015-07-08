package ryancheng.weatherdemo.presenter;

import ryancheng.weatherdemo.view.View;

/**
 * Created by 瑞 on 2015/7/6.
 */
public interface Presenter<T extends View> {
    void onCreate(T view);
    void onDestroy();
}
