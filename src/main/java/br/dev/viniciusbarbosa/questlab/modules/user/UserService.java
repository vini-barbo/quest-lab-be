package br.dev.viniciusbarbosa.questlab.modules.user;

import lombok.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

interface UserRepository extends JpaRepository<UserEntity, Integer> {
}

@Service
@RequiredArgsConstructor
class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("UserEntity not found"));
    }

    public UserEntity create(UserDTO userDto) {

        UserEntity userToCreate = new UserEntity();

        userToCreate.setName(userDto.getName());
        userToCreate.setEmail(userDto.getEmail());
        userToCreate.setPassword(userDto.getPassword());
        userToCreate.setRole(userDto.getRole());
        userToCreate.onCreate();
        return userRepository.save(userToCreate);
    }

    public UserEntity update(Integer id, UserEntity userDetails) {
        UserEntity user = findById(id);
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setUpdatedAt(Instant.now());
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}