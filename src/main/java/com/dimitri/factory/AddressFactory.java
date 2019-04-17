package com.dimitri.factory;

import com.dimitri.domain.Address;

public class AddressFactory {

    public static Address getAddress(String sAdr, String pAdr, String ct, String prov){

        return new Address.Builder().streetAddress(sAdr)
                .postalAddress(pAdr)
                .city(ct)
                .province(prov)
                .build();
    }
}
