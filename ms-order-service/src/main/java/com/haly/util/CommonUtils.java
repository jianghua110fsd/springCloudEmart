package com.haly.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class CommonUtils {

	private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String shortDateFormat = "yyyy-MM-dd";
    private static final String dateFormat2 = "yyyy/MM/dd HH:mm:ss";
    private static final String shortDateFormat2 = "yyyy/MM/dd";

	public static Date dateConverter(String dateStr, String fromToFlg) {
		StringBuilder bd = new StringBuilder();
		try {
            SimpleDateFormat formatter;
            if (dateStr.contains("-")) {
                if (dateStr.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                	if (StringUtils.equals(fromToFlg, "T")) {
                		// when date(to) but not appointed to seconds, add the final time string to the input date string
                		bd.append(dateStr).append(" 23:59:59");
                		dateStr = bd.toString();
                		formatter = new SimpleDateFormat(dateFormat);
                	} else {
                		formatter = new SimpleDateFormat(shortDateFormat);
                	}
                }
                Date dtDate = formatter.parse(dateStr);
                return dtDate;
            } else if (dateStr.contains("/")) {
                if (dateStr.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat2);
                } else {
                	if (StringUtils.equals(fromToFlg, "T")) {
                		bd.append(dateStr).append(" 23:59:59");
                		dateStr = bd.toString();
                		formatter = new SimpleDateFormat(dateFormat2);
                	} else {
                		formatter = new SimpleDateFormat(shortDateFormat2);
                	}
                }
                Date dtDate = formatter.parse(dateStr);
                return dtDate;
            }
            
            return null;
        } catch (Exception e) {
            return null;
        }

	}
}
