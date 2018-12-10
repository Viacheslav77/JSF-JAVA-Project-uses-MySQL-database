package com.forever.products;

import com.forever.interfaces.CategoryInterface;
import com.forever.interfaces.ProductInterface;
import java.util.List;
import java.util.Set;
import lombok.Setter;
import lombok.ToString;


@Setter 

public  abstract class AbstractProduct implements ProductInterface, java.io.Serializable {
  
    private Long id;   
    private String name;
    private String shortName;
    private byte[] image;    
    private List <byte[]> imagesList;   
    private  CategoryInterface category;  
    private String description;  
    private Long vendorCode;  
    private String shortDescription;    
    private double price;   
    private Integer rating;
    private Long voteCount; 
    private Set votes;  
    

//<editor-fold defaultstate="collapsed" desc=" реализованные гетеры ">
    
    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public byte[] getImage() {
       return image;
    }

    @Override
    public List<byte[]> getImagesList() {
        return imagesList;
    }

    @Override
    public CategoryInterface getCategory() {
         return category;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getShortDescription() {
        return shortDescription;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Integer getRating() {
        return rating;
    }

    @Override
    public Long getVoteCount() {
        return voteCount;
    }

    @Override
    public Set getVotes() {
        return votes;
    }
    
    @Override
    public Long getVendorCode() {
        return vendorCode;
    }
    
   //</editor-fold>

    @Override
    public String toString() {
        return "AbstractProduct{" + "id=" + id + ", name=" + name + ", shortName=" + shortName + ", category=" + category + ", description=" + description + ", vendorCode=" + vendorCode + ", shortDescription=" + shortDescription + '}';
    }

    
    
}
