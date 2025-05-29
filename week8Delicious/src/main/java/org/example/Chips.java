package org.example;

public enum chips implements OrderItem {

    Lays,
    Doritos,
    Sun_Chips;



    public double addchips(String user) {
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
    public double calculateCost() {
        return 1.50;
    }

}


