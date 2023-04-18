package net.javaguildes.springboot.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguildes.springboot.dto.UserDTO;
import net.javaguildes.springboot.entity.User;
import net.javaguildes.springboot.exception.ResourceNotFoundException;
import net.javaguildes.springboot.mapper.UserMapper;
import net.javaguildes.springboot.repository.UserRepository;
import net.javaguildes.springboot.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        log.info("find all user");
        return this.userRepository.findAll()
                .stream()
                .map(UserMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public UserDTO findById(Long id) {
        log.info("find user by id: {}", id);
        return this.userRepository.findById(id)
                .map(UserMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User", "ID", id.toString(), "USER_NOT_FOUND"));
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO userDTO) {
        log.info("save user: {}", userDTO);
        User entity = UserMapper.INSTANCE.toEntity(userDTO);
        User savedUser = this.userRepository.save(entity);
        log.info("save successfully");
        return UserMapper.INSTANCE.toDTO(savedUser);
    }

    @Override
    @Transactional
    public UserDTO update(Long id, UserDTO userDTO) {
        log.info("update user: {}", id);
        UserDTO userInDB = this.findById(id);
        userDTO.setId(id);
        UserMapper.INSTANCE.copyPropertiesNotNull(userDTO, userInDB);

        User entity = UserMapper.INSTANCE.toEntity(userInDB);
        this.userRepository.save(entity);
        log.info("update user successfully");
        return userInDB;
    }

    @Override
    @Transactional
    public String delete(Long id) {
        log.info("delete user: {}", id);
        this.findById(id);
        this.userRepository.deleteById(id);
        log.info("delete user {} successfully", id);
        return "Successfully";
    }
}
