package com.forever.sections;

import com.forever.interfaces.CategoryInterface;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class Category implements CategoryInterface {
    private Long id;
    private String name;
    private String section;

}
