package org.example;

public class Chips implements OrderItem {


//    public String Lays;
//    public String Doritos;
//    public String SunChips;

    private String chipType;

    public Chips(String type){
      this.chipType = type;
    }



    static double addchips(String user) {
        //todo fix and link code
        switch (user) {
            case "yes": {
                return 1.50;
            }
            case "no": {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "chips:" + chipType;
    }

    @Override
    public double calculateCost() {
        return 1.50;
    }

    @Override
    public String printToReceipt() {
        return "chips: $1.50";
    }
}


