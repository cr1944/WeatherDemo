package ryancheng.weatherdemo.view;

import ryancheng.weatherdemo.model.Weather;

/**
 * Created by 瑞 on 2015/7/6.
 */
public interface DetailView extends View {
    void showDetail(Weather weather);
    void showError(String error);
    void showLoading();
    void hideLoading();
}
