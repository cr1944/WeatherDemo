package ryancheng.weatherdemo.injector;

import javax.inject.Singleton;

import dagger.Component;
import ryancheng.weatherdemo.API;
import ryancheng.weatherdemo.WeatherApp;

/**
 * Created by 瑞 on 2015/7/6.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    WeatherApp app();
    API api();
}
