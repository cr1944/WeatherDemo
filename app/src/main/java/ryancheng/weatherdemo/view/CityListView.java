package ryancheng.weatherdemo.view;

import java.util.List;

import ryancheng.weatherdemo.model.City;

/**
 * Created by 瑞 on 2015/7/6.
 */
public interface CityListView extends View {
    void showCityList(List<City> cities);
    void showLoading();
    void hideLoading();
}
