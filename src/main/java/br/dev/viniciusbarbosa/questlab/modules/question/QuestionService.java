package br.dev.viniciusbarbosa.questlab.modules.question;

import lombok.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {}

@Service
@RequiredArgsConstructor
class QuestionService {

    private final QuestionRepository questionRepository;
    
    public List<QuestionEntity> findAll() {
        return questionRepository.findAll();
    }
    
    public QuestionEntity findById(Integer id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("QuestionEntity not found"));
    }
    
    public QuestionEntity create(QuestionEntity question) {
        return questionRepository.save(question);
    }
    
    public QuestionEntity update(Integer id, QuestionEntity questionDetails) {
        QuestionEntity question = findById(id);
        question.setName(questionDetails.getName());
        question.setEmail(questionDetails.getEmail());
        question.setPassword(questionDetails.getPassword());
        question.setUpdatedAt(Instant.now());
        return questionRepository.save(question);
    }
    
    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }
}