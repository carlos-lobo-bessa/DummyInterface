package awesomecompany.pt.dummyinterface.Adapters;

import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Comparator;
import java.util.List;

import awesomecompany.pt.dummyinterface.Models.FoodType;
import awesomecompany.pt.dummyinterface.R;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder>{

    private final SortedList<FoodType> mDataset = new SortedList<>(FoodType.class, new SortedList.Callback<FoodType>() {
        @Override
        public int compare(FoodType a, FoodType b) {
            return mComparator.compare(a, b);
        }

        @Override
        public void onInserted(int position, int count) {
            notifyItemRangeInserted(position, count);
        }

        @Override
        public void onRemoved(int position, int count) {
            notifyItemRangeRemoved(position, count);
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onChanged(int position, int count) {
            notifyItemRangeChanged(position, count);
        }

        @Override
        public boolean areContentsTheSame(FoodType oldItem, FoodType newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areItemsTheSame(FoodType item1, FoodType item2) {
            return (item1.name + item1.description + item1.kal).equals(item2.name + item2.description + item2.kal);
        }
    });
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView lineName;
        public TextView adicionalInformation;
        public TextView kal;

        public ViewHolder(View v) {
            super(v);
            lineName = v.findViewById(R.id.adapter_food_line_row_lineName);
            adicionalInformation = v.findViewById(R.id.adapter_food_line_row_adicional_information);
            kal = v.findViewById(R.id.adapter_food_line_row_lineName_kal);
        }
    }

    private List<FoodType> mDatasetCopy;
    private final Comparator<FoodType> mComparator;

    // Provide a suitable constructor (depends on the kind of dataset)
    public FoodListAdapter(Comparator<FoodType> comparator) {
        mComparator = comparator;
    }

    public FoodType selectedFoodType;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FoodType newFoodType = (FoodType) view.getTag();
            FoodType oldFoodType = selectedFoodType;
            if (oldFoodType == newFoodType){
                selectedFoodType = null;
                view.setSelected(false);
            }
            else
            {
                selectedFoodType = newFoodType;
                if (oldFoodType != null){
                    FoodListAdapter.this.notifyDataSetChanged();
                    return;
                }
                view.setSelected(true);
            }
        }
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View v = inflater.inflate(R.layout.adapter_food_line_row, parent, false);

        FoodListAdapter.ViewHolder vh = new FoodListAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        FoodType foodType = mDataset.get(position);
        holder.itemView.setTag(foodType);
        holder.itemView.setOnClickListener(mOnClickListener);
        holder.lineName.setText(foodType.name);
        holder.adicionalInformation.setText(foodType.description);
        holder.kal.setText(foodType.kal);

        holder.itemView.setSelected(foodType == selectedFoodType);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void add(FoodType model) {
        mDataset.add(model);
    }

    public void remove(FoodType model) {
        mDataset.remove(model);
    }

    public void add(List<FoodType> models) {
        mDataset.addAll(models);
    }

    public void remove(List<FoodType> models) {
        mDataset.beginBatchedUpdates();
        for (FoodType model : models) {
            mDataset.remove(model);
        }
        mDataset.endBatchedUpdates();
    }

    public void replaceAll(List<FoodType> models) {
        mDataset.beginBatchedUpdates();
        for (int i = mDataset.size() - 1; i >= 0; i--) {
            final FoodType model = mDataset.get(i);
            if (!models.contains(model)) {
                mDataset.remove(model);
            }
        }
        mDataset.addAll(models);
        mDataset.endBatchedUpdates();
    }

}
