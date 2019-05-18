package com.erp4j.ssm.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    private Date parse;

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
             parse = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parse;
    }
}
