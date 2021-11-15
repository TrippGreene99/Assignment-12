import java.util.ArrayList;

public class Restaurant {
    static ArrayList<Food> madeFood;
    private ArrayList<Thread> workers;
    private ArrayList<Thread> customers;

    public Restaurant() {
        madeFood = new ArrayList<>();
        workers = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void open() {
        Thread f1 = new Thread(new FryCook());
        Thread f2 = new Thread(new FryCook());
        Thread f3 = new Thread(new FryCook());
        Thread f4 = new Thread(new FryCook());
        Thread b1 = new Thread(new BurgerCook());
        Thread b2 = new Thread(new BurgerCook());
        Thread b3 = new Thread(new BurgerCook());

        workers.add(f1);
        workers.add(f2);
        workers.add(f3);
        workers.add(f4);
        workers.add(b1);
        workers.add(b2);
        workers.add(b3);

        for (int index = 0; index < workers.size(); index++) {
            workers.get(index).start();
        }
    }

    public void openDoors() {
        Thread[] c = new Thread[100];
        for (int index = 0; index < 100; index++) {
            c[index] = new Thread(new Customer());
            customers.add(c[index]);
            try {
                customers.get(index).start();
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void currentCookedFood() {
        int x = 0;
        int y = 0;

        for (int index = 0; index < madeFood.size(); index++) {

            if (madeFood.get(index) instanceof Burgers) {
                y++;
            }

            if (madeFood.get(index) instanceof Fries) {
                x++;
            }
            System.out.println("Currently we have " + x + " fries, and " + y + " burgers");

        }

    }


    public static void main(String[] args) {
        Restaurant stingers = new Restaurant();
        System.out.println("We are open!");
        stingers.open();
        stingers.openDoors();
        for (int index = 0; index < 10; index++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stingers.currentCookedFood();
        }

        System.out.println("We are closed");

    }

}
