package com.oneframe.utils;

import java.io.File;

public class FileDownloading {

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().contains(fileName))
                return flag=true;
        }

        return flag;
    }
}
