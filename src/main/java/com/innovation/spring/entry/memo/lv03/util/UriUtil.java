package com.innovation.spring.entry.memo.lv03.util;

import java.net.URI;

public class UriUtil {

    public static URI getRedirectUriAfterSignUp() {
        return URI.create("api/auth/signin");
    }
}
