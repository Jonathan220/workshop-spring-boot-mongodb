package com.jonathan.workshopmongodb.services;

import com.jonathan.workshopmongodb.domain.User;
import com.jonathan.workshopmongodb.dtos.UserDTO;
import com.jonathan.workshopmongodb.repositories.UserRepository;
import com.jonathan.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj){
        Optional<User> newObj = userRepository.findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj.get());
    }

    private void updateData(Optional<User> newObj, User obj) {
        if(newObj.isPresent()){
            newObj.get().setName(obj.getName());
            newObj.get().setEmail(obj.getEmail());
        }else{
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
    }
}
