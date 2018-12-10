package com.forever.controllers;

import com.forever.interfaces.ProductInterface;
import com.forever.interfaces.SectionInterface;
import com.forever.sections.BeautySection;
import java.io.Serializable;
import java.util.Map;
import com.forever.sections.HealthSection;
import com.forever.sections.OtherSection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.forever.interfaces.ForeverShopInterface;
import java.util.Locale;
import lombok.Getter;

@Getter
@ManagedBean(eager = true)
@SessionScoped
public class ForeverShopController implements ForeverShopInterface, Serializable{
    
    private final Map<String, SectionInterface> sections;        
    private List <ProductInterface> selectedProducts;
    
    private String selectedSection;
    private long selectedCategoryId;   
    private Locale currentLocale;
    private Integer selectedProductId;
    

    public ForeverShopController() {
        
        sections = new HashMap <> ();
            sections.put("Health",new HealthSection());
            sections.put("Beauty",new BeautySection());
            sections.put("Other...",new OtherSection());
            
        selectedProducts = new ArrayList<>();
        currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }
    
    public List <SectionInterface> getSectionsList (){
       
        List <SectionInterface> sectionsList = new ArrayList(sections.values());
       
        return sectionsList;
    }
    
    @Override
    public void setSelectedProducts(){
        
        setClearSelectedProducts();

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        selectedSection = params.get("section_name");
        selectedCategoryId = Long.valueOf(params.get("category_id"));  

        System.out.println(" selectedSection = " + selectedSection + " selectedCategoryId = " + selectedCategoryId);

        selectedProducts = sections.get(selectedSection).getProductsListByCategoryId(selectedCategoryId);
               
    }
    
    @Override
     public List <ProductInterface> getSelectedProducts(){
                  
         if(selectedSection==null){
             return selectedProducts;
         }
         try {
            if(!(currentLocale == FacesContext.getCurrentInstance().getViewRoot().getLocale())){
              selectedProducts = sections.get(selectedSection).getProductsListByCategoryId(selectedCategoryId);
         }
        } catch (Exception e) {
        }

            return selectedProducts;
     }   
     
    @Override
     public void setClearSelectedProducts (){
         
        selectedSection = null;
        selectedProductId = null;
        selectedProducts.clear();
     }
     
    public boolean getEmptySelectedProducts (){
        
        return selectedProducts.isEmpty();
    }
    
    public String getSelectedCategory(){
        
        return sections.get(selectedSection).getCategoryList().get((int)selectedCategoryId-1).getName();
    }
    
    public void setSelectedProduct(){
      
       Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();      
      
       selectedProductId= Integer.valueOf(params.get("selected_product_id"));  
       
       System.out.println(" selected_product_id = " + selectedProductId);               
    }
    
    public void clearSelectedProduct(){
    
       selectedProductId= null;  
       
       System.out.println(" selected_product_id = " + selectedProductId);               
    }
    
    public ProductInterface getSelectedProduct(){
        
        int index = selectedProductId - (int) ( selectedProducts.get(0).getId());
        
        System.out.println("index = " + index);
        
        return getSelectedProducts().get(index);
        
    }
 

 
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


          
}


