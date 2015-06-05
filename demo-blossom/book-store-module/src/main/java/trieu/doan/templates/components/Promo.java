package trieu.doan.templates.components;

import info.magnolia.module.blossom.annotation.ComponentCategory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by trieudoan on 6/4/2015.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ComponentCategory
public @interface Promo {
}
