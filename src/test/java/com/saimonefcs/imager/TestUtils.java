package com.saimonefcs.imager;

import java.io.File;

public class TestUtils {

    public static File load(String filePath) {
        ClassLoader classLoader = TestUtils.class.getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());
        return file;
    }
}
