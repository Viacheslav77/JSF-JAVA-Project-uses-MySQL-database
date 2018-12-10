package com.forever.sections;

import com.forever.interfaces.CategoryInterface;
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

public class CategoryList {
    
    public static List<CategoryInterface> getCategories(String name) {
         
        System.out.println(name + "------------------");
        
        
        List <CategoryInterface> categoryList = new ArrayList <> ();
        
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DatabaseJDBC.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery( 
                      "select *  "
                    + "from dir_Category c   "
                    + "inner join dir_Sections s on c.section_id = s.id "
                    + "where s.name_en = \"" + name + "\"");
            
            
            while (rs.next()) {
                
                Category category = new Category();               
                
                Locale currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
                
                        
                System.out.println(name + "----" + rs.getString("name_"+currentLocale));   
                
                category.setId(rs.getLong("id"));
                category.setName(rs.getString("name_"+currentLocale));
                category.setSection(rs.getString("s.name_"+currentLocale));
                
                categoryList.add(category);
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

        return categoryList;
    }

//    public List<Category> getCategoryList() {
//        if (!categoryList.isEmpty()) {
//            return categoryList;
//        } else {
//            return getCategories();
//        }
//    }
    

    
}
    
    


