package com.dimitri.factory;

import com.dimitri.domain.Notices;
import com.dimitri.util.IdGenerator;

public class NoticesFactory {
    public static Notices getNotices(String not){
        return new Notices.Builder().noticeID(IdGenerator.generateId())
                .notice(not)
                .build();
    }
}
