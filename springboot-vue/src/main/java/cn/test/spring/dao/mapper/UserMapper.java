package cn.test.spring.dao.mapper;

import cn.test.spring.dao.pojo.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    User findUserByName(String username);
    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);


    /**
     * 更新用户
     * @param user
     */
    void  update(User user);

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> getAll();

    /**
     * 根据id查找
     * @param id
     */
    void findById(Long id);


    /**
     * 根据email查找
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * 模糊查询号码
     * @param tel
     * @return
     */

    Page<User> listUsersByTel(String tel);


    /**
     * 导入表格
     * @param users
     * @return
     */
    void listFileToDb(User users);


    Integer listFileToDb(@Param("userList") List<User> users);
}
