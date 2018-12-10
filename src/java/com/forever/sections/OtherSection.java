package com.forever.sections;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(eager = true)
@SessionScoped
public class OtherSection extends AbstractSection{
    
    public OtherSection() {
        this.name = "Other...";
    
    }
    
    
}
