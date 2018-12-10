package com.forever.web.beans;

import com.forever.interfaces.ProductInterface;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DataTableWrapper {
    private ProductInterface column1;
    private ProductInterface column2;
    private ProductInterface column3;
}
