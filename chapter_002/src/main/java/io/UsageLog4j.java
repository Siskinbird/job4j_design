package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte bt = -112;
        short shrt = 16442;
        int i = 466623;
        char chr = 'Z';
        boolean blin = true;
        long lng = 67492970950L;
        double dbl = 00000.001;
        float flt = 1.4e-45f;
        LOG.debug("Byte type: {}", bt);
        LOG.debug("Short type: {}", shrt);
        LOG.debug("Int type: {}", i);
        LOG.debug("Long type: {}", lng);
        LOG.debug("Float type: {}", flt);
        LOG.debug("Double type: {}", dbl);
        LOG.debug("Char type: {}", chr);
        LOG.debug("Boolean type: {}", blin);
    }
}
