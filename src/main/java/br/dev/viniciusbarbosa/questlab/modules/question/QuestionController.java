package br.dev.viniciusbarbosa.questlab.modules.question;

import java.util.List;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public List<QuestionEntity> getAllQuestions() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public QuestionEntity getQuestionById(@PathVariable Integer id) {
        return questionService.findById(id);
    }

    @PostMapping
    public QuestionEntity createQuestion(@RequestBody QuestionEntity question) {
        return questionService.create(question);
    }

    @PutMapping("/{id}")
    public QuestionEntity updateQuestion(@PathVariable Integer id, @RequestBody QuestionEntity question) {
        return questionService.update(id, question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Integer id) {
        questionService.delete(id);
    }
}