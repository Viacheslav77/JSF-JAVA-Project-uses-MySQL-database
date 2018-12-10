package com.forever.interfaces;

import java.util.List;

public interface SectionInterface {
    
    String getName();
    
    String getNameSectionLocale();
    
    List<CategoryInterface> getCategoryList ();
    
    List<ProductInterface> getAllProductsList();
    
    List<ProductInterface> getProductsListByCategoryId(long selectedCategoryId);

    
    
    
    
}
