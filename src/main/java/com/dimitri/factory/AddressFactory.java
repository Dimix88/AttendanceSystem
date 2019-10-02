package com.dimitri.factory;

import com.dimitri.domain.Address;
import com.dimitri.util.IdGenerator;

public class AddressFactory {

    public static Address getAddress(String sAdr, String pAdr, String ct, String prov){

        return new Address.Builder().addressCode(IdGenerator.generateId())
                .streetAddress(sAdr)
                .postalAddress(pAdr)
                .city(ct)
                .province(prov)
                .build();
    }
}
