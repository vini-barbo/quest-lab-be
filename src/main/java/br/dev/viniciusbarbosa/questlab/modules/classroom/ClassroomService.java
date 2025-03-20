package br.dev.viniciusbarbosa.questlab.modules.classroom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

interface ClassroomRepository extends JpaRepository<ClassroomEntity, Integer> {

}

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    public List<ClassroomEntity> findAll() {
        return classroomRepository.findAll();
    }

    public ClassroomEntity findById(Integer id) {
        return classroomRepository.findById(id).orElseThrow(() -> new RuntimeException("Classroom not found"));
    }
}
