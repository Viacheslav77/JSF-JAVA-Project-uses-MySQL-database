package com.forever.sections;

import com.forever.interfaces.CategoryInterface;
import com.forever.interfaces.ProductInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.forever.interfaces.SectionInterface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.context.FacesContext;


public abstract class AbstractSection implements SectionInterface, Serializable{

    protected String name;
    
    protected String nameSectionLocale;
    
    protected List<CategoryInterface> categoryList;
    protected List<ProductInterface> productsList;
    protected CategoryInterface selectedCategory;
    
    protected Map <CategoryInterface, List<ProductInterface >> products;
    
    private Locale currentLocale;


    public AbstractSection() {      
        this.categoryList = new ArrayList<> ();
        this.productsList = new ArrayList<> ();
        
        this.products = new HashMap <> ();
        this.currentLocale = new Locale("ru");
        this.nameSectionLocale = name;
    }
    
    
    @Override
    public String getName() {
           
        return name;
    }
    
    @Override
     public String getNameSectionLocale() {
        
       checkProducts();
        
        return nameSectionLocale;
    }
    
    @Override
    public List<CategoryInterface> getCategoryList() {                   
        
        checkProducts();
        
        return  categoryList;
    }

    private void checkProducts() {
      
        if(products.isEmpty() || !(currentLocale == FacesContext.getCurrentInstance().getViewRoot().getLocale())){
            
            if(!products.isEmpty()){    
                products.clear();
            }

            CategoryList.getCategories(name).forEach((key) -> {
                products.put(key, new ArrayList <> ());
                        });
                    
            categoryList.clear();
            categoryList.addAll(products.keySet());                
            Collections.sort(categoryList, (a, b) -> a.getId().compareTo(b.getId()));

            nameSectionLocale = categoryList.get(0).getSection();
        }
    }
    
    
    
    @Override
    public List<ProductInterface> getAllProductsList() {
        if(productsList.isEmpty()){
        
        }
        return productsList;
    }
    
    @Override
    public List<ProductInterface> getProductsListByCategoryId(long selectedCategoryId) {
        
        setSelectedCategory (selectedCategoryId) ;
        
        System.out.println(selectedCategory.getName()+"===========================");
        
        if(products.get(selectedCategory).isEmpty()){
            products.put(selectedCategory, ProductstList.getProducts(selectedCategoryId, name));
        }

        return products.get(selectedCategory);
    }
    
    public void setSelectedCategory (long selectedCategoryId) {
        products.keySet().stream().filter(
                    (category) -> (category.getId()==selectedCategoryId)).forEachOrdered(
                            (category) -> {  selectedCategory =  category; });
        
    }

    
}
