package icu.weboys.sundriesplugin.obj;

import java.io.Serializable;

public class QS implements Serializable {
    String name;
    String des;
    String url;
    String icon;
    Boolean y;
    Boolean visible;

    public QS(){

    }
    public QS(String name, String des, String url, String icon, Boolean y, Boolean visible) {
        this.name = name;
        this.des = des;
        this.url = url;
        this.icon = icon;
        this.y = y;
        this.visible = visible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getY() {
        return y;
    }

    public void setY(Boolean y) {
        this.y = y;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
