package ryancheng.weatherdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ryancheng.weatherdemo.injector.ActivityModule;
import ryancheng.weatherdemo.injector.AppModule;
import ryancheng.weatherdemo.injector.DaggerActivityComponent;
import ryancheng.weatherdemo.injector.DaggerAppComponent;
import ryancheng.weatherdemo.model.City;
import ryancheng.weatherdemo.presenter.CityListPresenter;
import ryancheng.weatherdemo.view.CityListView;

public class MainActivity extends AppCompatActivity implements CityListView {
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    @InjectView(R.id.progressBar)
    ProgressBar progressBar;
    @Inject
    CityListPresenter cityListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initView();
        initializeDependencyInjector();
        cityListPresenter.onCreate(this);
        cityListPresenter.load();
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    private void initializeDependencyInjector() {
        WeatherApp weatherApp = (WeatherApp) getApplication();
        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(weatherApp.getAppComponent())
                .build().inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cityListPresenter.onDestroy();
    }

    @Override
    public void showCityList(List<City> cities) {
        CityListAdapter adapter = new CityListAdapter(this, cities);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }
}
