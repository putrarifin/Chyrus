package com.chyrus.chyrus.services;

import com.chyrus.chyrus.BuildConfig;

/**
 * Created by Chyrus on 5/20/17.
 */

public class ApiList {

//    private static final String BASE_URL = BuildConfig.BASEURL;
    private static final String BASE_URL = BuildConfig.GITHUB;

    public static String getMainURL() {
        return BASE_URL;
    }

}
