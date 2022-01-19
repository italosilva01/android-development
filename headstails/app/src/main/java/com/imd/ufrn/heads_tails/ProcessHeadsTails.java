package com.imd.ufrn.heads_tails;

import java.util.Random;

public class ProcessHeadsTails {

    public int getResult(){

        int result = new Random().nextInt(11);
        return  result%2;
    }

}
