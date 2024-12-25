package com.vcom.base.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VcomLog {

    public final static String TAG = "VcomLog";
    private static String MYLOG_PATH_SDCARD_DIR = "/sdcard/Android/data/com.baidu.ycdriver/VcomLogs/";
    //    private static String MYLOG_PATH_SDCARD_DIR = Environment.getDataDirectory().getAbsolutePath();
    private static int SDCARD_LOG_FILE_SAVE_DAYS = 7;
    private static String FILE_NAME = "Log.txt";
    private static SimpleDateFormat myLogSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static SimpleDateFormat logfile = new SimpleDateFormat("yyyyMMdd");
    private static boolean isDel;
    private static boolean permission = true;

    public static void init(Context context) {
//        MYLOG_PATH_SDCARD_DIR = context.getFilesDir().getAbsolutePath() + "/VcomLogs/";
    }

    public static void log(String message) {
        writeLogToFile("V", TAG, message);
        Log.i(TAG, message);
    }

    public static void v(String tag, String message) {
        writeLogToFile("V", tag, message);
        Log.v(tag, message);
    }

    public static void d(String tag, String message) {
        writeLogToFile("D", tag, message);
        Log.d(tag, message);
    }

    public static void i(String tag, String message) {
        writeLogToFile("I", tag, message);
        Log.i(tag, message);
    }

    public static void w(String tag, String message) {
        writeLogToFile("W", tag, message);
        Log.w(tag, message);
    }

    public static void e(String tag, String message) {
        writeLogToFile("E", tag, message);
        Log.e(tag, message);
    }

    private static void writeLogToFile(String lvl, String tag, String message) {
        if (!permission) {
            return;
        }
        if (!isDel) {
            delLogFile();
        }
        Date date = new Date();
        String fileName = logfile.format(date) + FILE_NAME;
        String logs = "\r\n[" +
                myLogSdf.format(date) +
                "-" +
                lvl +
                "] " +
                tag +
                "/" +
                message;
        File file = new File(MYLOG_PATH_SDCARD_DIR);
        boolean ret = true;
        if (!file.exists()) {
            ret = file.mkdir();
        }
        if (!ret) {
            return;
        }
//        file = new File(MYLOG_PATH_SDCARD_DIR + "/" + fileName);
        file = new File(MYLOG_PATH_SDCARD_DIR, fileName);
        if (!file.exists()) {
            //先得到文件的上级目录，并创建上级目录，在创建文件
            file.getParentFile().mkdir();
            try {
                //创建文件
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(logs);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            permission = false;
            Log.i(TAG, e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 删除7天前的日志
     */
    public static void delLogFile() {
        File folder = new File(MYLOG_PATH_SDCARD_DIR);
        if (folder.exists()) {
            File file;
            String[] fileList = folder.list();
            if (fileList != null) {
                for (int i = 0; i < fileList.length; i++) {
                    if (fileList[i].contains(FILE_NAME)) {
                        if (isNeedDel(fileList[i])) {
                            file = new File(folder, fileList[i]);
                            if (file.exists()) {
                                file.delete();
                                i(TAG, "已删除日志:" + fileList[i]);
                            }
                        }
                    }
                }
            }
        }
        isDel = true;
    }


    /**
     * 判断当前文件是否需要删除（7天前的日志删除）
     *
     * @param fileName 当前文件的文件名
     * @return
     */
    private static boolean isNeedDel(String fileName) {
        for (int i = 0; i < 7; i++) {
            Date date = getBeforeDate(i);
            if (fileName.contains(logfile.format(date))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取当天之前的日期
     *
     * @param beforeDay 距离当天的天数
     * @return
     */
    private static Date getBeforeDate(int beforeDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -beforeDay);
        return calendar.getTime();
    }

}
