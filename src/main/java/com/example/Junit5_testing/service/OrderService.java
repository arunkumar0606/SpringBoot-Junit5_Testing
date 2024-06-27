package com.example.Junit5_testing.service;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    public int totalOrder(int a,int b){
        return a+b;
    }

    public int multipleOrder(int a,int b){
        return a*b;
    }

    public int subTractOrder(int a,int b){
        return Math.abs(a-b);
    }

    public boolean isCostly(int a){
        return a>100;
    }

    public Object isGood(int a){
        if(a>1000){
            return "Very Costly";
        }
        else{
            return null;
        }
    }
}
