package com.forever.interfaces.users;

import com.forever.interfaces.ProductInterface;


public interface UserInterface {
    
    String getName();
    
    String getLastName();
    
    String getUserGroups();
    
    void buy(ProductInterface product);

    void returnGoods(ProductInterface product);

  
}
