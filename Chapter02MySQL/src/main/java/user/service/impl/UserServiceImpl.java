package user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;
import user.dao.UserDAO;
import user.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public String getExistId(String id) {
		UserDTO userDTO = userDAO.getExistId(id);
		System.out.println(userDTO);
		
		if(userDTO == null) {return "non_exist";}
		else {return "exist";}	
	}

	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
	}

	@Override
	public List<UserDTO> list() {
		Map<String, Integer> map = new HashMap<>();
		map.put("startNum", 0);
		map.put("endNum", 20);
		return userDAO.list(map);
	}

	@Override
	public UserDTO getUserDTO(String id) {
		return userDAO.getUserDTO(id);
	}

}
