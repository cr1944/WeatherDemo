package ryancheng.weatherdemo;

import android.app.Application;

import ryancheng.weatherdemo.injector.AppComponent;
import ryancheng.weatherdemo.injector.AppModule;
import ryancheng.weatherdemo.injector.DaggerAppComponent;

/**
 * Created by 瑞 on 2015/7/6.
 */
public class WeatherApp extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
