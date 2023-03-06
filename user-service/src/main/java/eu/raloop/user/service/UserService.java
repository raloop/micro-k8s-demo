package eu.raloop.user.service;

import eu.raloop.user.VO.Department;
import eu.raloop.user.VO.ResponseTemplateVO;
import eu.raloop.user.entity.User;
import eu.raloop.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of userService");
        return userRepository.save(user);
    }


    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of userService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                        Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
