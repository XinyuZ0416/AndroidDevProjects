package xinyuz0416.android.planets;

import android.content.Context;
import android.view.*;
import android.widget.*;

import androidx.annotation.*;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetsArrayList;
    Context context;

    public MyCustomAdapter( ArrayList<Planet> planetsArrayList, Context context) {
        super(context, R.layout.item_list_layout, planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }


    private static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the planet object for the current position
        Planet planets = getItem(position);

        // Inflate Layout:
        MyViewHolder myViewHolder;
        final View result;

        if (convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

            // Finding Views:
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount  = (TextView) convertView.findViewById(R.id.moon_count_text);
            myViewHolder.planetImg  = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

            convertView.setTag(myViewHolder);
        }else{
            // the view is recycled
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        // Getting the data from model class (Planet)
        myViewHolder.planetName.setText(planets.getPlanetName());
        myViewHolder.moonCount.setText(planets.getMoonCount());
        myViewHolder.planetImg.setImageResource(planets.getPlanetImage());

        return result;

    }
}

