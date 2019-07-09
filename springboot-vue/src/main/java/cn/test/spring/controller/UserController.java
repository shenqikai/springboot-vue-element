package cn.test.spring.controller;
import cn.test.spring.dao.pojo.Result;
import cn.test.spring.dao.pojo.StatusCode;
import cn.test.spring.dao.pojo.User;
import cn.test.spring.service.ExcelService;
import cn.test.spring.service.InputService;
import cn.test.spring.service.UserService;
import cn.test.spring.util.FileConstUtil;
import cn.test.spring.util.FormatUtil;
import cn.test.spring.util.PoiUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Api(tags = "用户api", description = "用户api", basePath = "/user")
@RestController
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    FormatUtil formatUtil;

    @Autowired
    ExcelService excelService;

    @Autowired
    InputService  inputService;

    //保留字符
    private static final String[] DISABLED_USERNAME = {"admin", "admins", "user", "users", "category", "categorys", "search", "bulletin", "notice", "forum", "question", "questions", "answer", "answers", "manage", "manages", "post", "posts", "article", "articles", "blog", "blogs", "ajax", "css", "js", "forum", "static", "public", "resource", "login", "logout", "forget", "resetpass", "reset", "template", "components", "css", "img", "images", "js", "getKaptchaImage", "匿名", "管理员", "站长", "版主"};


    /**
     * 获取所有用户
     *
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "获取所有用户", notes = "page+size",produces = "application/json")
    @GetMapping("/getAllUsers")
    public Result list(@RequestParam(defaultValue = "0") final Integer page,
                       @RequestParam(defaultValue = "0") final Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return Result.create(StatusCode.OK,"获取所有用户成功",pageInfo);
    }


    /**
     * 注册
     *
     * @param user
     * @return
     */

    @ApiOperation(value = "获取所有用户", notes = "User 对象",produces = "application/json")
    @PostMapping("/register")
    public Result register(@Validated @RequestBody final User user, BindingResult r){
        logger.info("register start");
        if(!formatUtil.checkStringNull(
                user.getPassword(),
                user.getUsername(),
                user.getAddress(),
                user.getEmail()
        )){
            return Result.create(StatusCode.ERROR, "不能为空");
        }

        try {
            if(r.hasErrors()){
                return  Result.create(StatusCode.ERROR, Objects.requireNonNull(r.getFieldError()).getDefaultMessage());
            }

            // 验证用户名长度
            if(user.getUsername() != null) {
                if (user.getUsername().trim().length() < 6 ||user.getUsername().trim().length()>12) {
                    return Result.create(StatusCode.ERROR,"用户名长度不合法");
                }

            }
            // 验证密码长度
            if (user.getPassword()!=null){
                if (user.getPassword().trim().length()<6 || user.getPassword().trim().length()>18){
                    return Result.create(StatusCode.ERROR,"密码长度不合法");
                }
            }
            // 验证用户名是否合法
            for (String str : DISABLED_USERNAME) {
                if (str.equals(user.getUsername())){
                    return  Result.create(StatusCode.ERROR,"用户名不合法");
                }

            }
            // 验证用户名是否存在
              if(userService.findUserByName(user.getUsername())!=null) {
                  return Result.create(StatusCode.ERROR,"用户名不能相同");
              }
            // 验证邮箱是否重复
              if (userService.findByEmail(user.getEmail())!=null) {
                  return Result.create(StatusCode.ERROR,"邮箱不能重复");
              }

              userService.register(user);
              return Result.create(StatusCode.OK,"成功");


        }catch (RuntimeException e){
            return Result.create(StatusCode.ERROR, "注册失败，" + e.getMessage());

        }

    }


    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    @ApiOperation(value = "根据用户名查询", notes = "username",produces = "application/json")
    @GetMapping("/findByUsername")
    public Result find(@RequestParam String username){

        if (username==null){
            return Result.create(StatusCode.ERROR,"获取失败");
        }
        User  dbUser=userService.findUserByName(username);
        return Result.create(StatusCode.OK,"获取成功",dbUser);
    }


    @PostMapping("/updateUser")
    public Result update(@Validated @RequestBody User user ,BindingResult r) {
        logger.info("update start");

        if(!formatUtil.checkStringNull(
                user.getPassword(),
                user.getUsername(),
                user.getAddress(),
                user.getEmail()
        )){
            return Result.create(StatusCode.ERROR, "不能为空");
        }

        try {
            if(r.hasErrors()){
                return  Result.create(StatusCode.ERROR, Objects.requireNonNull(r.getFieldError()).getDefaultMessage());
            }

            // 验证用户名长度
            if(user.getUsername() != null) {
                if (user.getUsername().trim().length() < 6 ||user.getUsername().trim().length()>12) {
                    return Result.create(StatusCode.ERROR,"用户名长度不合法");
                }

            }
            // 验证密码长度
            if (user.getPassword()!=null){
                if (user.getPassword().trim().length()<6||user.getPassword().trim().length()>18){
                    return Result.create(StatusCode.ERROR,"密码长度不合法");
                }
            }
            // 验证用户名是否合法
            for (String str : DISABLED_USERNAME) {
                if (str.equals(user.getUsername())){
                    return  Result.create(StatusCode.ERROR,"用户名不合法");
                }

            }

            userService.update(user);
            return Result.create(StatusCode.OK,"更新成功");

        }catch (RuntimeException e){
            return Result.create(StatusCode.ERROR, "注册失败，" + e.getMessage());

        }
    }



    @DeleteMapping("/{id}")
    public Result removeUser(@PathVariable Long id) {

        userService.findById(id);
        return Result.create(StatusCode.OK,"刪除成功");
    }


    @ApiOperation(value = "根据用户名查询", notes = "username",produces = "application/json")
    @GetMapping("/findByTel")
    public Result findByTel(@RequestParam Map<String,Object> params){

            String tel = params.get("tel").toString();
            if(tel.trim().length()==0){
                List<User> list = userService.getAllUsers();
                return Result.create(StatusCode.OK,"获取所有用户成功",list);
            }
        if (tel.trim().length()<=11){
            Page<User> userList=userService.listUsersByTel(tel);
            return Result.create(StatusCode.OK,"获取成功",userList);
        }else {
            return Result.create(StatusCode.ERROR,"手机号不能大于11位!");
        }


    }


    /**
     * 导出excel文件
     * @return
     * @throws IOException
     */
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportExcel() throws IOException {
        return PoiUtils.exportUserExcel(userService.getAllUsers());
    }


    /**
     * 导入excel文件
     * @param file
     * @param req
     * @return
     * @throws IOException
     */
    @PostMapping("/import")
    public Result importFile(MultipartFile file, HttpServletRequest req) throws IOException {
        String a=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        logger.info("文件名是"+a);
        if (!FileConstUtil.ExcelMessage.EXTS.contains(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1))){
            return  Result.create(StatusCode.ERROR,"类型不正确");
        }
            List<User> users = inputService.parseFileList(file);
            if (users.isEmpty()){
                return  Result.create(StatusCode.ERROR,"导入失败，请检查格式");
            }
            else {
                userService.listFileToDb(users);
                return Result.create(StatusCode.OK, "导入成功!",users);
            }
    }
}
