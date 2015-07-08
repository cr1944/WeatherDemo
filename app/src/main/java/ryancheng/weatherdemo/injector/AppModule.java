package ryancheng.weatherdemo.injector;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import ryancheng.weatherdemo.API;
import ryancheng.weatherdemo.Config;
import ryancheng.weatherdemo.WeatherApp;

/**
 * Created by 瑞 on 2015/7/6.
 */
@Module
public class AppModule {
    private final WeatherApp weatherApp;

    public AppModule(WeatherApp weatherApp) {
        this.weatherApp = weatherApp;
    }

    @Provides
    @Singleton
    WeatherApp provideApp() {
        return weatherApp;
    }

    @Provides
    @Singleton
    API provideApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Config.END_POINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        return restAdapter.create(API.class);
    }
}
