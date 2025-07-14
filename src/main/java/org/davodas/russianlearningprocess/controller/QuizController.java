package org.davodas.russianlearningprocess.controller;

import org.davodas.russianlearningprocess.model.QuizQuestion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class QuizController {
    private final String[] russianCharacters = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н",
            "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я"};

    private final String[] foneticEquivalentForRussianCharacters = {"A", "B", "V", "G", "D", "E/Ye", "Yo/Jo", "Zh", "Z", "I", "Y/I/J", "K", "L", "M", "N",
            "O", "P", "R", "S", "T", "U", "F", "Kh/H", "Ts/C", "Ch", "Sh", "ShCh", "Hard sign", "Y", "'", "E", "Yu", "Ya"};

    @GetMapping("/")
    public String showQuestion(Model model) {
        Random random = new Random();
        int index = random.nextInt(russianCharacters.length);

        String russianCharacter = russianCharacters[index];
        String rightAnswer = foneticEquivalentForRussianCharacters[index];

        Set<String> options = new HashSet<>();
        options.add(rightAnswer);
        while (options.size() < 3) {
            int randIndex = random.nextInt(foneticEquivalentForRussianCharacters.length);
            options.add(foneticEquivalentForRussianCharacters[randIndex]);
        }

        List<String> optionsList = new ArrayList<>(options);
        Collections.shuffle(optionsList);

        QuizQuestion quizQuestion = new QuizQuestion(russianCharacter, optionsList, rightAnswer);
        model.addAttribute("quizQuestion", quizQuestion);

        return "quiz";
    }

    @PostMapping("/verify")
    public String verificarRespuesta(@RequestParam String selection, @RequestParam String rightAnswer, Model model) {
        boolean isRightAnswer = selection.equals(rightAnswer);
        model.addAttribute("isRightAnswer", isRightAnswer);
        model.addAttribute("rightAnswer", rightAnswer);
        return "result";
    }
}
