package ryancheng.weatherdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import ryancheng.weatherdemo.model.City;

/**
 * Created by 瑞 on 2015/7/7.
 */
public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.ItemViewHolder> {
    private List<City> cities;
    private Context context;

    public CityListAdapter(Context context, List<City> cities) {
        this.context = context;
        this.cities = cities;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.city = cities.get(position);
        holder.textView.setText(holder.city.name);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        @InjectView(android.R.id.text1)
        TextView textView;
        City city;
        @OnClick(android.R.id.text1)
        void showWeather() {
            Intent intent = new Intent(textView.getContext(), DetailActivity.class);
            intent.putExtra("title", city.name);
            textView.getContext().startActivity(intent);
        }

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
