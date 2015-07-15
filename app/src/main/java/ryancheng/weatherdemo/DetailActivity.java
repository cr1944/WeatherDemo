package ryancheng.weatherdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ryancheng.weatherdemo.injector.ActivityModule;
import ryancheng.weatherdemo.injector.DaggerActivityComponent;
import ryancheng.weatherdemo.model.Weather;
import ryancheng.weatherdemo.presenter.DetailPresenter;
import ryancheng.weatherdemo.view.DetailView;

public class DetailActivity extends AppCompatActivity implements DetailView {
    @InjectView(R.id.progressBar)
    ProgressBar progressBar;
    @InjectView(R.id.detail)
    TextView detailView;
    @Inject
    DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.inject(this);
        Intent intent = getIntent();
        String cityName = intent.getStringExtra("title");
        setTitle(cityName);
        initializeDependencyInjector();
        detailPresenter.onCreate(this);
        detailPresenter.load(cityName);
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
        detailPresenter.onDestroy();
    }

    @Override
    public void showDetail(Weather weather) {
        detailView.setText(weather.getRetData().toString());
    }

    @Override
    public void showError(String error) {
        detailView.setText(error);
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
