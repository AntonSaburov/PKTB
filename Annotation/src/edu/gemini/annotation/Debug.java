package edu.gemini.annotation;

import java.lang.annotation.Retention;

/* Данная аннотация говорит о том, что написанная нами аннотация
 * @interface Debug будет доступна через рефлексию во время
 * исполнения программы
*/
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Debug {
    // Описание параметра для аннотации - здесь тип String
    String comment();
}

