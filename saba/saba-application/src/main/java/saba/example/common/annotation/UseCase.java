package saba.example.common.annotation;


import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Transactional
public @interface UseCase {
}
