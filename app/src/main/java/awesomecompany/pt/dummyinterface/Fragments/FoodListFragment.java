package awesomecompany.pt.dummyinterface.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import awesomecompany.pt.dummyinterface.Adapters.FoodListAdapter;
import awesomecompany.pt.dummyinterface.Models.FoodType;
import awesomecompany.pt.dummyinterface.Models.FoodTypeEnum;
import awesomecompany.pt.dummyinterface.R;
import awesomecompany.pt.dummyinterface.Repository.FoodRepo;

public class FoodListFragment extends  Fragment implements SearchView.OnQueryTextListener {

    private List<FoodType> mDataset = new ArrayList<FoodType>();

    private static final Comparator<FoodType> comparator = new Comparator<FoodType>() {
        @Override
        public int compare(FoodType a, FoodType b) {
            return (a.name+a.description+a.kal).compareTo(b.name+b.description+b.kal);
        }
    };

    private RecyclerView mRecyclerView;
    //private RecyclerView.Adapter mAdapter;
    private FoodListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FoodListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        boolean isFirstTab = getArguments().getBoolean("isFirstTab");
        int position = getArguments().getInt("pos");
        FoodTypeEnum foodType = getFoodType(isFirstTab, position);

        mDataset = FoodRepo.getFoodList(foodType);
        setHasOptionsMenu(true);

        super.onCreate(savedInstanceState);
    }

    private FoodTypeEnum getFoodType(boolean isFirstTab, int position)
    {
        if(isFirstTab)
        {
            switch (position){
                case 1:
                    return FoodTypeEnum.CHOCOLATE;
                case 2:
                    return FoodTypeEnum.GREENS;
                case 3:
                    return FoodTypeEnum.MEAT;
                case 4:
                    return FoodTypeEnum.DESSERT;
            }
        }
        else
        {
            switch (position){
                case 1:
                    return FoodTypeEnum.WATER;
                case 2:
                    return FoodTypeEnum.JUICE;
                case 3:
                    return FoodTypeEnum.WINE;
                case 4:
                    return FoodTypeEnum.ENERGYDRINK;
            }
        }

        return FoodTypeEnum.CHOCOLATE;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content_food_list, container, false);
        mRecyclerView = view.findViewById(R.id.fragment_lines_recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new FoodListAdapter(comparator);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.add(mDataset);

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        final List<FoodType> filteredModelList = filter(mDataset, newText);
        mAdapter.replaceAll(filteredModelList);
        mRecyclerView.scrollToPosition(0);
        return true;
    }

    private static List<FoodType> filter(List<FoodType> models, String query) {
        final String lowerCaseQuery = query.toLowerCase();

        final List<FoodType> filteredModelList = new ArrayList<>();
        for (FoodType model : models) {
            final String name = model.name.toLowerCase();
            final String kal = model.kal.toLowerCase();
            if (name.contains(lowerCaseQuery)  || kal.contains(lowerCaseQuery) ) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
