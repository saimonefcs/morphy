package com.saimonefcs.imager;

import java.io.File;

public class ImagerTestUtils {

    public static File load(String filePath) {
        ClassLoader classLoader = ImagerTestUtils.class.getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());
        return file;
    }
}
