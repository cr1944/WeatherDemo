package ryancheng.weatherdemo;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;
import rx.Observable;
import ryancheng.weatherdemo.model.Weather;

/**
 * Created by 瑞 on 2015/7/6.
 */
public interface API {
    @GET("/apistore/weatherservice/cityname")
    public Observable<Weather> getWeatherByName(@Query("cityname") String cityname,
                                                @Header("apikey") String apikey);
}
