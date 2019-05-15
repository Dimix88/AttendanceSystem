package com.dimitri.factory;

import com.dimitri.domain.Admin;
import com.dimitri.util.IdGenerator;

public class AdminFactory {
    public static Admin getAdmin(String level){
        return new Admin.Builder().adminID(IdGenerator.generateId())
                .adminLevel(level)
                .build();
    }
}
