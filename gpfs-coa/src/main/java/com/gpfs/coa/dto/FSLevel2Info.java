package com.gpfs.coa.dto;

import java.util.List;
import java.util.Optional;

import com.gpfs.core.model.BaseEntity;

public class FSLevel2Info extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String series;
    private String description;
    private String name;
    private List<FSLevel3Info> children;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<FSLevel3Info> getChildren() {
        return children;
    }
    public void setChildren(List<FSLevel3Info> children) {
        this.children = children;
    }
    public FSLevel3Info getChildByName(String fs3Name) {
        Optional<FSLevel3Info> fs3Opt = this.getChildren().stream().filter(fs1 -> fs3Name.equals(fs1.getName())).findFirst();
        if (fs3Opt.isPresent()) {
            return fs3Opt.get();
        }
        return null;
    }

}
