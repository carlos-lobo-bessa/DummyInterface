package awesomecompany.pt.dummyinterface.Repository;

import java.util.ArrayList;
import java.util.List;

import awesomecompany.pt.dummyinterface.Models.FoodType;
import awesomecompany.pt.dummyinterface.Models.FoodTypeEnum;

public class FoodRepo {

    private static List<FoodType> chocolateDataset = new ArrayList<FoodType>();
    private static List<FoodType> greensDataset = new ArrayList<FoodType>();
    private static List<FoodType> meatDataset = new ArrayList<FoodType>();
    private static List<FoodType> dessertDataset = new ArrayList<FoodType>();
    private static List<FoodType> waterDataset = new ArrayList<FoodType>();
    private static List<FoodType> juiceDataset = new ArrayList<FoodType>();
    private static List<FoodType> wineDataset = new ArrayList<FoodType>();
    private static List<FoodType> energyDrinkDataset = new ArrayList<FoodType>();

    private FoodType routeBuilder(String name, String kal, String description){
        FoodType r = new FoodType();
        r.name= name;
        r.kal= kal;
        r.description = description;

        return r;
    }

    public void createLists()
    {
        chocolateDataset.add(routeBuilder("Kitkat","210", "desc"));
        chocolateDataset.add(routeBuilder("Twix","280", "desc"));
        chocolateDataset.add(routeBuilder("Nestle Crunch ","220", "desc"));
        chocolateDataset.add(routeBuilder("Chunky","190", "desc"));
        chocolateDataset.add(routeBuilder("Snickers ","280", "desc"));
        chocolateDataset.add(routeBuilder("SKOR","210", "desc"));
        chocolateDataset.add(routeBuilder("Ferrero Rocher","220", "desc"));
        chocolateDataset.add(routeBuilder("Krackel","210", "desc"));

        greensDataset.add(routeBuilder("Cabbage","35.8", "desc"));
        greensDataset.add(routeBuilder("Spinach","27", "desc"));
        greensDataset.add(routeBuilder("Kale","21", "desc"));
        greensDataset.add(routeBuilder("Dandelion greens","45", "desc"));
        greensDataset.add(routeBuilder("COLLARD GREENS","60", "desc"));
        greensDataset.add(routeBuilder("ARUGULA","30", "desc"));
        greensDataset.add(routeBuilder("ROMAINE","42", "desc"));
        greensDataset.add(routeBuilder("Broccoli","19", "desc"));
        greensDataset.add(routeBuilder("Asparagus","43", "desc"));

        meatDataset.add(routeBuilder("Beef","407", "desc"));
        meatDataset.add(routeBuilder("Chicken","731", "desc"));
        meatDataset.add(routeBuilder("Duck","2137", "desc"));
        meatDataset.add(routeBuilder("Filet Mignon","278", "desc"));
        meatDataset.add(routeBuilder("Ham","236", "desc"));
        meatDataset.add(routeBuilder("Pork","363", "desc"));
        meatDataset.add(routeBuilder("Spare Ribs","3332", "desc"));
        meatDataset.add(routeBuilder("T-Bone Steak","580", "desc"));
        meatDataset.add(routeBuilder("Turkey","7205", "desc"));

        dessertDataset.add(routeBuilder("Apple Crisp","156", "desc"));
        dessertDataset.add(routeBuilder("Ice Cream Cake","240", "desc"));
        dessertDataset.add(routeBuilder("Donut","242", "desc"));
        dessertDataset.add(routeBuilder("Pancake","86", "desc"));
        dessertDataset.add(routeBuilder("Pumpkin Pie","323", "desc"));
        dessertDataset.add(routeBuilder("Tiramisu","492", "desc"));
        dessertDataset.add(routeBuilder("Waffles","103", "desc"));

        waterDataset.add(routeBuilder("Normal Water","0", "Really? What did you expected to find here?"));

        juiceDataset.add(routeBuilder("7up","156", "desc"));
        juiceDataset.add(routeBuilder("Coke","149", "desc"));
        juiceDataset.add(routeBuilder("Coke Zero","0", "hmmm sure"));
        juiceDataset.add(routeBuilder("Fanta","138", "desc"));
        juiceDataset.add(routeBuilder("Pepsi","156", "96"));
        juiceDataset.add(routeBuilder("Tonic Water","124", "desc"));
        juiceDataset.add(routeBuilder("Sprite","131", "desc"));

        energyDrinkDataset.add(routeBuilder("Red Bull","110", "desc"));
        energyDrinkDataset.add(routeBuilder("Monster Energy","100", "desc"));
        energyDrinkDataset.add(routeBuilder("Rockstar","20", "desc"));
        energyDrinkDataset.add(routeBuilder("Amp Energy","220", "desc"));
        energyDrinkDataset.add(routeBuilder("No Fear Energy(0 sugar)","10", "desc"));

        wineDataset.add(routeBuilder("Rose Wine","84", "desc"));
        wineDataset.add(routeBuilder("Merlot","98", "desc"));
        wineDataset.add(routeBuilder("Champagne","90", "desc"));
        wineDataset.add(routeBuilder("White Wine","97", "desc"));
        wineDataset.add(routeBuilder("Sweet Wines","98", "desc"));
        wineDataset.add(routeBuilder("Sangria","156", "desc"));
        wineDataset.add(routeBuilder("Port Wine","189", "desc"));



    }

    public static List<FoodType> getFoodList(FoodTypeEnum foodType) {

        switch (foodType){
            case CHOCOLATE:
                return chocolateDataset;
            case GREENS:
                return  greensDataset;
            case MEAT:
                return meatDataset;
            case DESSERT:
                return dessertDataset;

            case WATER:
                return waterDataset;
            case JUICE:
                return juiceDataset;
            case WINE:
                return wineDataset;
            case ENERGYDRINK:
                return energyDrinkDataset;
            default:
                return chocolateDataset;
        }
    }
}
