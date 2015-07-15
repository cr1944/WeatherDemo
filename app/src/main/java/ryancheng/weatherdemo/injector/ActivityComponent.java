/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package ryancheng.weatherdemo.injector;


import android.content.Context;

import java.util.List;

import dagger.Component;
import ryancheng.weatherdemo.DetailActivity;
import ryancheng.weatherdemo.MainActivity;
import ryancheng.weatherdemo.model.City;

@Activity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(DetailActivity activity);
    Context context();
    List<City> cityList();
}
