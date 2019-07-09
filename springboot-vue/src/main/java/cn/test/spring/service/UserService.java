package cn.test.spring.service;

import cn.test.spring.dao.pojo.User;
import com.github.pagehelper.Page;


import java.util.List;

public interface UserService  {


    /**
     * 根据id查找
     *
     * @param id
     */
    void findById(Long id);

    /**
     * 根据email查找
     *
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * 根据username查找
     *
     * @param username
     * @return
     */
    User findUserByName(String username);

    /**
     * 用户注册
     *
     * @param userToAdd
     */
    void register(User userToAdd);

    /**
     * 更新用户
     *
     * @param update
     */
    void  update(User update);

    /**
     * 删除用户
     *
     * @param id
     */
    void remove(Long id);

    /**
     * 获取所有用户列表
     *
     * @return
     */
    List<User> getAllUsers();

    /**
     * 根据电话号码模糊查询
     *
     * @param tel
     * @return
     */
    Page<User> listUsersByTel(String tel);


    /**
     * 导入Excel
     *
     * @param users
     * @return
     */
    Integer  listFileToDb(List<User> users);
}
