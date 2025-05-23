package org.example;

public enum chips {

    addchips;

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

}
