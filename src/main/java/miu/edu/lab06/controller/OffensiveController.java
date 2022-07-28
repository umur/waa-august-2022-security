package miu.edu.lab06.controller;

import miu.edu.lab06.aspect.WaaWord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/offensive")
public class OffensiveController {

    @PostMapping("check")
    @WaaWord
    public List<String> checkOffensiveWords(@RequestBody List<String> words) {
        return words;
    }
}
