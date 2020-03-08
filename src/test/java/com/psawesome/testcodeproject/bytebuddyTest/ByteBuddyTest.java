package com.psawesome.testcodeproject.bytebuddyTest;

import com.psawesome.testcodeproject.bytebuddyTest.model.MyParentClass;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * package: com.psawesome.testcodeproject.lombokTest.model
 * author: PS
 * DATE: 2020-03-09 월요일 00:26
 */
public class ByteBuddyTest {

    @Test
    void initTest() throws IOException {
        DynamicType.Unloaded<MyParentClass> make = new ByteBuddy()
                .subclass(MyParentClass.class)
                .defineField("psAwesome", String.class, Visibility.PUBLIC)
                .defineField("isBody", Long.class, Visibility.PUBLIC)
                .make();

        for (Field field : make.load(MyParentClass.class.getClassLoader())
                .getLoaded()
                .getFields()) {
            System.out.println("field.getName() = " + field.getName());
        }
    }
}
