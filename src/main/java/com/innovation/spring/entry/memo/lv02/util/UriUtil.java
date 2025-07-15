package com.innovation.spring.entry.memo.lv02.util;

import java.net.URI;

public class UriUtil {

    public static URI getSignInUri() {
        return URI.create("api/auth/signin");
    }
}
