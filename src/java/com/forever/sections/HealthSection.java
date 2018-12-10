package com.forever.sections;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(eager = true)
@SessionScoped
public class HealthSection extends AbstractSection{
    
     public HealthSection() {
        this.name = "Health";
    }
}
