package ryancheng.weatherdemo.presenter;

import java.util.List;

import javax.inject.Inject;

import ryancheng.weatherdemo.model.City;
import ryancheng.weatherdemo.view.CityListView;

/**
 * Created by 瑞 on 2015/7/6.
 */
public class CityListPresenter implements Presenter<CityListView> {
    private final List<City> cities;
    private CityListView cityListView;

    @Inject
    public CityListPresenter(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public void onCreate(CityListView view) {
        this.cityListView = view;
    }

    public void load() {
        cityListView.hideLoading();
        cityListView.showCityList(cities);
    }

    @Override
    public void onDestroy() {

    }
}
