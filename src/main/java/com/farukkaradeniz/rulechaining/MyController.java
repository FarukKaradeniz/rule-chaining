package com.farukkaradeniz.rulechaining;

import com.farukkaradeniz.rulechaining.checker.NameRuleChecker;
import com.farukkaradeniz.rulechaining.checker.RuleChecker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @PostMapping
    public ResponseEntity<PersonOutput> check(@RequestBody Person person) {

        RuleChecker ruleChecker = new NameRuleChecker();
        while (ruleChecker.nextRule() != null) {
            ruleChecker.check(person);
            ruleChecker = ruleChecker.nextRule();
        }

        if (ruleChecker.nextRule() == null) {
            ruleChecker.check(person);
        }

        return ResponseEntity.ok(new PersonOutput("SUCCESS"));
    }

}
