package xinyuz0416.android.volumecalculator;

import android.content.Context;
import android.view.*;
import android.widget.*;

import androidx.annotation.*;

import java.util.ArrayList;

// Responsible for creating the view for each item and binding data to it

public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapesArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Shape> shapesArrayList, Context context) {
        super(context, R.layout.grid_item_layout, shapesArrayList);
        this.shapesArrayList = shapesArrayList;
        this.context = context;
    }

    // View Holder
    private static class MyViewHolder{
        TextView shapeName;
        ImageView shapeImg;
    }

    // create and return a view for a specific item in Grid.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the shape object for the current position
        Shape shapes = getItem(position);

        // Inflating Layout:
        MyViewHolder myViewHolder;

        if (convertView == null){
            // no view went off-screen -> Create a new view
            myViewHolder= new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false
            );

            // Finding the Views
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.textView);
            myViewHolder.shapeImg  = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(myViewHolder);



        }else{
            // a view went off-screen -> re-use it
            myViewHolder = (MyViewHolder) convertView.getTag();

        }


        // Getting the data from the model class (Shape)
        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImg.setImageResource(shapes.getShapeImg());

        return convertView;

    }
}
