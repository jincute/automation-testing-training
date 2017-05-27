package com.ecvictor.calculator;

/**
 * Created by caoc on 3/18/2017.
 */
class Calculator {
    static int add(int i, int j){

        return i+j;
    }

    static int divide(int i, int j) throws Exception{

        if(j==0){
            throw new Exception(" j can't equal to 0 ");
        }
        else{
            return i/j;
        }
    }
}
