/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package ryancheng.weatherdemo.injector;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import ryancheng.weatherdemo.API;
import ryancheng.weatherdemo.model.City;

@Module
public class ActivityModule {

    private final Context mContext;

    public ActivityModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Activity
    Context provideActivityContext() {
        return mContext;
    }

    @Provides
    @Activity
    List<City> provideCityList() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("北京"));
        cities.add(new City("上海"));
        return cities;
    }

}
