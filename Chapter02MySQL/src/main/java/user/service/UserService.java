package user.service;

import java.util.List;

import user.bean.UserDTO;

public interface UserService {

	public String getExistId(String id);

	public void write(UserDTO userDTO);

	public List<UserDTO> list();

	public UserDTO getUserDTO(String id);

}
