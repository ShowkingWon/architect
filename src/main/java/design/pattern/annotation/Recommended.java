package design.pattern.annotation;


import java.lang.annotation.*;

/**
 * 实际开发推荐使用的。
 *
 * @author  Jerry Wan
 * @date 2021/1/14 0:33
 * @description
 */
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface Recommended {
    String value() default "";
}
