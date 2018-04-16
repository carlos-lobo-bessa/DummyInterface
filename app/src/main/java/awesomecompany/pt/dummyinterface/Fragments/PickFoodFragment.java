package awesomecompany.pt.dummyinterface.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import awesomecompany.pt.dummyinterface.FoodListActivity;
import awesomecompany.pt.dummyinterface.Models.FoodType;
import awesomecompany.pt.dummyinterface.R;

public class PickFoodFragment extends Fragment {

    private Boolean isFirstTab;

    public PickFoodFragment() {
        // Required empty public constructor
    }

    public static PickFoodFragment newInstance(Boolean firstTab) {
        PickFoodFragment myFragment = new PickFoodFragment();

        Bundle args = new Bundle();
        args.putBoolean("isFirstTab", firstTab);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food_list, container, false);

        isFirstTab = getArguments().getBoolean("isFirstTab", true);

        if(!isFirstTab)
        {
            TextView pos1Text = view.findViewById(R.id.fragment_food_list_pos_1_text);
            ImageView pos1Image = view.findViewById(R.id.fragment_food_list_pos_1_image);

            TextView pos2Text = view.findViewById(R.id.fragment_food_list_pos_2_text);
            ImageView pos2Image = view.findViewById(R.id.fragment_food_list_pos_2_image);

            TextView pos3Text = view.findViewById(R.id.fragment_food_list_pos_3_text);
            ImageView pos3Image = view.findViewById(R.id.fragment_food_list_pos_3_image);

            TextView pos4Text = view.findViewById(R.id.fragment_food_list_pos_4_text);
            ImageView pos4Image = view.findViewById(R.id.fragment_food_list_pos_4_image);

            pos1Text.setText(R.string.fragment_food_list_water);
            pos1Image.setImageResource(R.drawable.soda_bottle);

            pos2Text.setText(R.string.fragment_food_list_juice);
            pos2Image.setImageResource(R.drawable.orange_juice);

            pos3Text.setText(R.string.fragment_food_list_wine);
            pos3Image.setImageResource(R.drawable.wine_glass);

            pos4Text.setText(R.string.fragment_food_list_energy_drink);
            pos4Image.setImageResource(R.drawable.energy_drink);
        }

        setListeners(view);

        return view;
    }

    private void setListeners(View view)
    {
        LinearLayout firstPos = view.findViewById(R.id.main_activity_pos_1);

        firstPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToFoodListActivity(1);
            }
        });

        LinearLayout secondPos = view.findViewById(R.id.main_activity_pos_2);

        secondPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToFoodListActivity(2);
            }
        });

        LinearLayout thirdPos = view.findViewById(R.id.main_activity_pos_3);

        thirdPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToFoodListActivity(3);
            }
        });

        LinearLayout forthPos = view.findViewById(R.id.main_activity_pos_4);

        forthPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToFoodListActivity(4);
            }
        });
    }

    public void switchToFoodListActivity(int pos)
    {
        Intent myIntent = new Intent(getActivity(), FoodListActivity.class);
        Bundle b = new Bundle();
        b.putInt("pos", pos);
        b.putBoolean("isFirstTab", isFirstTab);
        myIntent.putExtras(b);
        startActivity(myIntent);
    }
}
