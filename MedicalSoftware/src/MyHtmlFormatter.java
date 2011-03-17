/**
 * MyHtmlFormatter.java
 *
 * Version 1.0
 * Copyright 2011 BobSoft Inc
 */
package edu.gatech.oad.logdemo.model;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;


/**
 * @author From an Example at exampledepot.com
 *
 */
class MyHtmlFormatter extends Formatter {
    // This method is called for every log records
    public String format(LogRecord rec) {
        StringBuffer buf = new StringBuffer(1000);
        // Bold any levels >= WARNING
        if (rec.getLevel().intValue() >= Level.WARNING.intValue()) {
            buf.append("<b>");
            buf.append(rec.getLevel());
            buf.append("</b>");
        } else {
            buf.append(rec.getLevel());
        }
        buf.append(' ');
        buf.append(rec.getMillis());
        buf.append(' ');
        buf.append(formatMessage(rec));
        buf.append('\n');
        return buf.toString();
    }

    // This method is called just after the handler using this
    // formatter is created
    public String getHead(Handler h) {
        return "<HTML><HEAD>"+(new Date())+"</HEAD><BODY><PRE>\n";
    }

    // This method is called just after the handler using this
    // formatter is closed
    public String getTail(Handler h) {
        return "</PRE></BODY></HTML>\n";
    }
}

