package com.learnenglishforkids.kidbox.learnenglishforkids.uti;

import java.lang.reflect.Field;

/**
 * Created by trand on 10/15/2017.
 */

public class uti {
    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }


}
