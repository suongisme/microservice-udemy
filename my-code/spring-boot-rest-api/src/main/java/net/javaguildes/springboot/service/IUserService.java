package net.javaguildes.springboot.service;

import net.javaguildes.springboot.dto.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO save(UserDTO userDTO);

    UserDTO update(Long id, UserDTO userDTO);

    String delete(Long id);
}
