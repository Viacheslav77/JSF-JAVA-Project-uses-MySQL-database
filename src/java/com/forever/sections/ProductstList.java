package com.forever.sections;

import com.forever.interfaces.CategoryInterface;
import com.forever.interfaces.ProductInterface;
import com.forever.products.AbstractProduct;
import com.forever.products.BeautyProduct;
import com.forever.products.HealthProduct;
import com.forever.products.OtherProduct;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.forever.web.db.DatabaseJDBC;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.faces.context.FacesContext;


public class ProductstList {
    
     public static List<ProductInterface> getProducts(long selectedCategoryId, String nameSection) {
        
        
        List <ProductInterface> productList = new ArrayList <> ();
        
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DatabaseJDBC.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery( "select *" +                                                                     
                                   
                                    "from " + nameSection + "_product hp " +
                                    "inner join product_properties pp on hp."+nameSection+"_id = pp.id " +
                                    "inner join dir_name dn on pp.name_id = dn.id " +                                           
                                    "inner join dir_description dd on pp.descr_id = dd.id " +
                                    "inner join dir_images di on pp.image_id = di.id " +       
                                    "inner join dir_category dc on pp.category_id = dc.id " +
                                    "inner join dir_sections ds on dc.section_id = ds.id " + 
                                    "where dc.id= \"" + selectedCategoryId + "\"" );
            
            while (rs.next()) {
                
                AbstractProduct product ;      
                Locale currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
                
                if(rs.getString("ds.name_en").equalsIgnoreCase("Health")){
                    product = new HealthProduct();
                }
                else if(rs.getString("ds.name_en").equalsIgnoreCase("Beauty")){
                     product = new BeautyProduct();
                }
                else {
                    product = new OtherProduct();
                }
                

                product.setId(rs.getLong("hp.id"));
                product.setName(rs.getString("dn.name_" + currentLocale));
                
                CategoryInterface category = new Category();
                
            
                category.setName(rs.getString("dc.name_" + currentLocale));
                category.setSection(rs.getString("ds.name_" + currentLocale));
                
                product.setCategory(category);
                
                product.setVendorCode(rs.getLong("pp.vendor_code"));
                product.setImage(rs.getBytes("di.image_1"));
                product.setShortDescription(rs.getString("dd.short_descr_" + currentLocale));
                product.setDescription(rs.getString("dd.descr_" + currentLocale));

                productList.add(product);
                
                System.out.println(product + "product----------"); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoryList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoryList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        productList.forEach( value -> System.out.println(value));
        
        return productList;
    }
     
//                                    "hp.id," +
//                                    "dn.name_ru," +
//                                    "dc.name_ru," +
//                                    "ds.id, " +
//                                    "ds.name_ru," +
//                                    "ds.name_en," +
//                                    "pp.vendor_code," +
//                                    "pp.image," +
//                                      "dd.short_descr_ru " +
    
}
