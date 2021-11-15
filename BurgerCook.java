public class BurgerCook extends Restaurant implements Runnable {
    private int id;
    private static int next_burgercook_id = 1;

    public BurgerCook() {
        this.id = next_burgercook_id++;
    }

    @Override
    public void run() {
        System.out.println("Burger cook #" + id + " is starting to cook");

        for (int index = 0; index < 50; index++) {
            System.out.println("Burger cook #" + id + " cooked a burger");
            Burgers burgers = new Burgers();
            madeFood.add(burgers);

            int x = ((int) (Math.random() * (1000 - 1))) + 1;
            try {
                Thread.sleep(x);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());

            }

        }

    }

}
