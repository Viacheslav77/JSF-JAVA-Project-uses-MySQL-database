package com.forever.web.beans;

import java.io.InputStream;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


public class ImageBean {
    
    private StreamedContent image;
    
    public ImageBean() {
        
        InputStream stream = this.getClass().getResourceAsStream("barcalogo.jpg");
        image = new DefaultStreamedContent(stream, "image/jpeg");
    }
    public StreamedContent getImage() {
    
        return this.image;
}
}
