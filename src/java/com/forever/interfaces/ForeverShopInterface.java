package com.forever.interfaces;

import java.util.List;
import java.util.Map;

public interface ForeverShopInterface {
    
    Map<String, SectionInterface> getSections ();
   
    List <ProductInterface> getSelectedProducts();
    
    void setSelectedProducts();
    
    void setClearSelectedProducts ();
 
}
