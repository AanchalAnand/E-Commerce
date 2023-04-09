package com.backendProject.SuperShop.Exception;

public class InsufficientQuantity extends  Exception{
    public InsufficientQuantity(String message){
        super(message);
    }
}