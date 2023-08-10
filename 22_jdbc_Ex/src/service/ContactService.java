package service;

import java.util.List;
import java.util.Map;

import dto.ContactDto;

//ContactMain -> ContactController -> ContactService -> ContactDao -> DB

public interface ContactService {

  // 5개의 서비스를 갖고있을 것이다.
  // 컨트롤러의 값은 map이다.
  int insert(Map<String, Object> map);
  int update(Map<String, Object> map);
  int delete(Map<String, Object> map);
  List<ContactDto> selectList();
  ContactDto selectContactByNo(Map<String, Object> map);
  
  
}
