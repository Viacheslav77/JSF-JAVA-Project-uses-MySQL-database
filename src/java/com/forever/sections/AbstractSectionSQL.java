package com.forever.sections;

import com.forever.interfaces.ProductInterface;
import com.forever.interfaces.SectionInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AbstractSectionSQL  {
   
    protected String section;
    
    protected List<Category> categoryList = new ArrayList <Category>();
    protected List<ProductInterface> productsList;
    
    
    public List<Category> getCategoryList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<ProductInterface> getAllProductsList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
