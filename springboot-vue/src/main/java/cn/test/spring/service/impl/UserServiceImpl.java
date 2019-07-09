package cn.test.spring.service.impl;
import cn.test.spring.dao.mapper.UserMapper;
import cn.test.spring.dao.pojo.User;
import cn.test.spring.service.UserService;
import com.github.pagehelper.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);


    @Autowired
    private UserMapper userMapper;


    /**
     * 根据id查找
     *
     * @param id
     */
    @Override
    public void findById(Long id) {
        userMapper.findById(id);
    }

    /**
     * 根据email查找
     *
     * @param email
     * @return
     */
    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }


    /**
     * 根据username查找
     *
     * @param username
     * @return
     */

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    /**
     * 用户注册
     *
     * @param userToAdd
     */
    @Override
    public void register(User userToAdd) {
        userMapper.saveUser(userToAdd);
        logger.info("register success");
    }

    /**
     * 更新用户
     *
     * @param update
     */
    @Override
    public void update(User update) {

        userMapper.update(update);

    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void remove(Long id) {
        userMapper.findById(id);
    }

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> getAllUsers(){

        return userMapper.getAll();


    }


    /**
     * 模糊查询根据手机号
     * @param tel
     * @return
     */
    @Override
    public Page<User> listUsersByTel(String tel) {
        return userMapper.listUsersByTel(tel);
    }


    /**
     * 导入Excel
     *
     * @param users
     * @return
     */
    @Override
    public Integer listFileToDb(List<User> users) {

        return userMapper.listFileToDb(users);
    }


}
