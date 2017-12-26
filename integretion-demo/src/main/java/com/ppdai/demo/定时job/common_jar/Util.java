package com.ppdai.demo.定时job.common_jar;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by huanglijun on 2017/12/26.
 */
public class Util {
    public static final Date MinDate = new Date(0L);
    private static final long millSecFrom1970 = 2649600000L;
    private static final long millSecOfGMT8 = 28800000L;

    public Util() {
    }

    public static String getExceptionInfo(Exception e) {
        try {
            StringWriter e2 = new StringWriter();
            PrintWriter pw = new PrintWriter(e2);
            e.printStackTrace(pw);
            return "\r\n" + e2.toString() + "\r\n";
        } catch (Exception var3) {
            return "bad getErrorInfoFromException";
        }
    }

    public static String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }

    public static boolean isEmpty(String dataString) {
        return dataString == null || dataString.isEmpty();
    }

    public static boolean isEmptyValue(String dataString) {
        return isEmpty(dataString) || "null".equals(dataString);
    }

    public static String getStringForJson(String value) {
        return value == null?"":(value.length() < 1?"":value);
    }

    /** @deprecated */
    @Deprecated
    public static String getUTCDateJsonWithZone() {
        Calendar cal = Calendar.getInstance();
        int zoneOffset = cal.get(15);
        int dstOffset = cal.get(16);
        cal.add(14, -(zoneOffset + dstOffset));
        long l = cal.getTimeInMillis();
        return "Date(" + String.valueOf(l) + ")";
    }

    /** @deprecated */
    @Deprecated
    public static String getUtcDateJsonWithMillTime(Calendar date) {
        Calendar cal = date == null?Calendar.getInstance():date;
        long timespan = cal.getTimeInMillis() - 2649600000L;
        return "Date(" + timespan + ")";
    }

    public static String getUtcDateJsonWithTime(Date t) {
        long l = (t == null?(new Date()).getTime():t.getTime()) + 28800000L;
        return "Date(" + l + ")";
    }
}
