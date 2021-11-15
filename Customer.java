public class Customer extends Restaurant implements Runnable {
    private int id;
    private static int next_customer_id = 1;
Customer() {
        this.id = next_customer_id++;
    }

    public void eatBurger() {
        System.out.println("Customer " + id + " wants burger");
        Burgers burgerToRemove=null;
        for (int index = 0; index < madeFood.size(); index++) {
            if (madeFood.get(index) instanceof Burgers) {
                burgerToRemove=(Burgers) madeFood.get(index);
                break;
            }
        }
        if (burgerToRemove == null)
            System.out.println("Oh no, we are out of Burgers!!!");
        else
            madeFood.remove(burgerToRemove);

    }

    public void eatFries() {
        System.out.println("Customer " + id + " wants fries");
        Fries friesToRemove=null;

        for (int index = 0; index < madeFood.size(); index++) {

            if (madeFood.get(index) instanceof Fries) {
                friesToRemove = (Fries) madeFood.get(index);
                break;
            }
        }


        if (friesToRemove == null) {
            System.out.println("Oh no, we are out of Fries!!!");
        }
        else
            madeFood.remove(friesToRemove);

    }

    @Override
    public void run() {
        System.out.println("Customer "+id+" has shown up");
        int sleepTime = ((int) (Math.random() * (3 - 2))) + 2;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int customerChoice = ((int) (Math.random() * (3 - 0))) + 0;
        if (customerChoice == 0) {
            eatBurger();
        } else if (customerChoice == 1) {
            eatBurger();
            eatFries();
        } else if (customerChoice == 2) {
            eatFries();
        }

    }

}
