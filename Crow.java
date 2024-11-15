import java.util.ArrayList;

public class Crow implements Contract{
    
private ArrayList<String> items;
private int bagSize;


    public Crow(){
        this.items = new ArrayList<>(1);
        this.bagSize = 1;

    }

    // class info checking methods

    public boolean contains(String item){
        if (this.items.contains(item)){
            return true;
        }
        return false;
    }

    public void capacity(){
        if ((this.items.size()) == this.bagSize) {
            System.out.println("Your bag is at capacity, you cannot add more items without dropping something first.");
        }
    }

    // user item methods

    public void grab(String item){
        if ((this.items.size() + 1) > this.bagSize){
            throw new RuntimeException("You don't have space in your bag for that!");
        }
        this.items.add(item);
        System.out.println("You added "+ item + " to your bag.");
        this.capacity();
    }

    public String drop(String item) {
        if (!this.contains(item)) {
            throw new RuntimeException("You can't drop that " + item + ", it is not in your bag");
        }
        this.items.remove(item);
        return item;
    }

    public void examine(String item) {
        System.out.println("You looked at " + item + ". It's just a(n) " + item + ".");
        // Provide information about whether item is in bag
        if (this.contains(item)){
            System.out.println(item + " is in your bag.");
        }
    }

    public void use(String item) {
        System.out.println("You used the "+ item + ". It has been removed from your bag.");
        this.drop(item);
    }    

    // bag size methods

    public Number grow(){
        this.bagSize += 1;
        System.out.println("Your bag can now hold " + this.bagSize + " items.");
        return this.bagSize;
    }

    public Number shrink(){
        if ((this.bagSize - 1) <= 0) {
            throw new RuntimeException("Bag size cannot be smaller than one.");
        }
        if ((this.bagSize - 1) < this.items.size()) {
            throw new RuntimeException("You have too many items to shrink your bag right now.");
        }
        this.bagSize -= 1;
        System.out.println("Your bag can now hold " + this.bagSize + " items.");
        this.capacity();
        return this.bagSize;
    }

    // User get info methods

    public void showInventory(){
        System.out.println("Your bag contains:");
        this.items.forEach((item) -> {
            System.out.println(" - " + item);
        });
    }

    public void checkCapacity(){
        System.out.println("Your bag can hold "+ this.bagSize + " items. It currently has " + this.items.size() + " items.");
    }

    // User movement methods

    public boolean walk(String direction){
        System.out.println("You walked " + direction + ".");
        return true;
    }

    public boolean fly(int x, int y){
        System.out.println("You flew around.");
        return true;
    }
    
    public void rest(){
        System.out.println("You curled up on the ground.");
    }

    public void undo(){
        System.out.println("You spun around in a cirle. Nothing else happened.");
    }




    public void showOptions(){
        System.out.println("You are a crow. You can \n + grab(String item)\n + drop(String item)\n + examine(String item)\n + use(String item)\n + grow()\n + shrink()\n + showInventory()\n + checkCapacity()\n + walk(String direction)\n + fly(int x, int y)\n + rest()\n + undo()");
    }


    public static void main(String[] args) {
        Crow meep = new Crow();
        meep.showOptions();
        meep.grab("The sauce");
        meep.grow();
        meep.shrink();
        meep.grow();
        meep.grab("jewel");
        meep.showInventory();
        meep.use("The sauce");
        meep.checkCapacity();
        meep.examine("jewel");
        meep.grab("The sauce");
        meep.grow();
        meep.grab("cup");
        meep.use("cup");
        meep.shrink();
        
    }
}
