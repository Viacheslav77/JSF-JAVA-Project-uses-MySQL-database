package com.forever.sections;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(eager = true)
@SessionScoped
public class BeautySection extends AbstractSection{
    
    public BeautySection() {
        this.name = "Beauty";
    }
}
