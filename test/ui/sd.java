package ui;
class Fish
{
    int weight=1;
}
class Lake {
    Fish fish;
    void setFish(Fish s)
    {
        fish=s;
    }
    void foodFish(int m)
    {
        fish.weight=fish.weight+m;
    }
}
public class sd {


    public static void main(String[] args) {
       Fish redFish=new Fish();
        System.out.println(redFish.weight);
        Lake lake=new Lake();
        lake.setFish(redFish);
        lake.foodFish(120);
        System.out.println(redFish.weight);

    }
}
