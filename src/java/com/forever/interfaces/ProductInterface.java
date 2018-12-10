package com.forever.interfaces;

import java.util.List;
import java.util.Set;

public interface ProductInterface {
   
    long getId();        
    
    String getName();
    
    String getShortName();
    
    byte[] getImage();
    
    List <byte[]> getImagesList();
    
    CategoryInterface getCategory(); 
    
    Long getVendorCode ();
    
    String getDescription ();
    
    String getShortDescription ();

    double getPrice();
    
    Integer getRating();
    
    Long getVoteCount();
    
    Set getVotes ();    
  
}
