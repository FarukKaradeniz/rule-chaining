package com.farukkaradeniz.rulechaining.checker;

import com.farukkaradeniz.rulechaining.Person;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

public class NameRuleChecker implements RuleChecker {
    @Override
    public RuleChecker nextRule() {
        return new SurnameRuleChecker();
    }

    @Override
    public void process(Person person) {
        if (!StringUtils.hasText(person.name())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "İsim boş olamaz");
        }
    }
}
