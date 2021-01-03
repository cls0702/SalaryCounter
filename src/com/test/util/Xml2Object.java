package com.test.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

public class Xml2Object {

    public static Object parse (String path, Class targetClass) throws JAXBException {
        if (isNotBlank(path)) {
            JAXBContext context = JAXBContext.newInstance(targetClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL resource = ClassLoader.getSystemResource(path);
            Object obj = unmarshaller.unmarshal(resource);
            return obj;
        }
        return null;
    }

    static boolean isNotBlank (String path) {
        return null != path && path.length() > 0;
    }

}
