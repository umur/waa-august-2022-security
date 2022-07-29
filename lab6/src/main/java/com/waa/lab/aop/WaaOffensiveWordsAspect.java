package com.waa.lab.aop;

import com.waa.lab.security.SecurityUtil;
import com.waa.lab.service.OffensiveWordLogService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaOffensiveWordsAspect {
    private final List<String> OFFENSIVE_WORDS = Arrays.asList("spring");
    private final String REDACT_CHAR = "*";

    private final OffensiveWordLogService offensiveWordLogService;

    @Pointcut("@annotation(com.waa.lab.aop.WaaOffensiveWords)")
    public void waaOffensiveWordsAnno(){}

    @Before("waaOffensiveWordsAnno() && args(param) && @annotation(anno)")
    public void checkOffensiveWords(Object param, WaaOffensiveWords anno) throws NoSuchFieldException, IllegalAccessException {
        for(String fieldName: anno.fieldNames()) {
            Field field = param.getClass().getDeclaredField(fieldName);
            if(field == null)
                continue;
            field.setAccessible(true);
            String word = (String) field.get(param);
            String offensiveWord = checkOffensiveWords(word);
            if (Strings.isNotEmpty(offensiveWord)) {
                String replacedWord = buildReplaceWord(word, offensiveWord);
                field.set(param, replacedWord);
                offensiveWordLogService.logOffensiveWords(SecurityUtil.getCurrentUser().getId(), word);
            }
        }
    }

    String checkOffensiveWords(String word){
        return OFFENSIVE_WORDS
                .stream()
                .filter( w -> word.contains(w))
                .findAny()
                .orElse(Strings.EMPTY);
    }

    String buildReplaceWord(String word, String offensive){
        String redactWord = String.join(Strings.EMPTY,
                Collections.nCopies(offensive.length(), REDACT_CHAR));
        return word.replace(offensive, redactWord);
    }
}
