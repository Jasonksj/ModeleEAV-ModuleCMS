package com.SamyBodio.AEVCms.model.moduleCMS;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;

import java.util.Date;

public abstract class NestedComponent {
    Attribute[] overrideAttributes ;
    Date startDate;
    Date end_date;
    boolean visible;

}
