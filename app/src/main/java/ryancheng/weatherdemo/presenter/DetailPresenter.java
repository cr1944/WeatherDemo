package ryancheng.weatherdemo.presenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import ryancheng.weatherdemo.API;
import ryancheng.weatherdemo.Config;
import ryancheng.weatherdemo.model.Weather;
import ryancheng.weatherdemo.view.DetailView;

/**
 * Created by 瑞 on 2015/7/6.
 */
public class DetailPresenter implements Presenter<DetailView> {
    private final API api;
    private DetailView detailView;

    public DetailPresenter(API api) {
        this.api = api;
    }

    @Override
    public void onCreate(DetailView view) {
        this.detailView = view;
    }

    public void load(String cityName) {
        detailView.showLoading();
        api.getWeatherByName(cityName, Config.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Weather>() {
                    @Override
                    public void onCompleted() {
                        detailView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailView.hideLoading();
                        detailView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(Weather weather) {
                        detailView.hideLoading();
                        detailView.showDetail(weather);
                    }
                });
    }

    @Override
    public void onDestroy() {

    }
}
