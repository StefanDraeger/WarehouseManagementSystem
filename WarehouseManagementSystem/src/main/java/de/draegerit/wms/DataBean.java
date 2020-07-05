package de.draegerit.wms;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import de.draegerit.wms.db.util.EPackmaterial;

@ManagedBean(name="dataBean")
@ApplicationScoped
public class DataBean {

    public EPackmaterial[] getPackmaterialien() {
        return EPackmaterial.values();
    }

}