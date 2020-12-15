package domain;

import util.TreeType;

import java.util.ArrayList;
import java.util.List;

public class ShopType {
    @TreeType("id")
    private int id;

    public ShopType(int parentid, String typename, String stype) {
        this.parentid = parentid;
        this.typename = typename;
        this.stype = stype;
    }

    @TreeType("pid")
    private int parentid;
    private String typename;
    @TreeType(level = "1,2,3")
    private String stype;
    @TreeType("list")
    private List<ShopType> children = new ArrayList<>();

    public List<ShopType> getChildren() {
        return children;
    }

    public void setChildren(List<ShopType> children) {
        this.children = children;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setParentid(int parentid) {
        this.parentid = parentid;
    }
    public void setTypename(String typename) {
        this.typename = typename;
    }
    public void setStype(String stype) {
        this.stype = stype;
    }
    public int getId() {
        return id;
    }
    public int getParentid() {
        return parentid;
    }
    public String getTypename() {
        return typename;
    }
    public String getStype() {
        return stype;
    }

    @Override
    public String toString() {
        return "{" +
                "name:\"" + typename + '\"' +
                ", children:" + children +
                '}';
    }

    public ShopType() {
    }
}
