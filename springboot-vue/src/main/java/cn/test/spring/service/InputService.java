package cn.test.spring.service;

import cn.test.spring.dao.mapper.UserMapper;
import cn.test.spring.dao.pojo.User;
import cn.test.spring.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InputService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    private static Logger logger = LogManager.getLogger(InputService.class);


    public List<User> parseFileList(MultipartFile file) throws IOException {
        Boolean res= false;

        List<User> Users = new ArrayList<>();
        HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
        HSSFSheet sheet = workbook.getSheetAt(0);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < physicalNumberOfRows; i++) {

            HSSFRow row = sheet.getRow(i);
            HSSFCell c0 = row.getCell(0);
            HSSFCell c1 = row.getCell(1);
            HSSFCell c2 = row.getCell(2);
            HSSFCell c3 = row.getCell(3);
            HSSFCell c4 = row.getCell(4);
            HSSFCell c5 = row.getCell(5);
            c5.setCellType(CellType.STRING);//因为号码是int类型，转换String类型时会出错，所以先给表格属性先设置好
            User user = new User();

            //判断用户名是否重复
            if (userService.findUserByName(c3.getStringCellValue())!=null) {
                double numericCellValue = c0.getNumericCellValue();

                user.setId((int) numericCellValue);
                user.setUsername(c1.getStringCellValue()); //姓名
                user.setPassword(c2.getStringCellValue());//密码
                user.setEmail(c3.getStringCellValue());//email
                user.setAddress(c4.getStringCellValue());//address
                user.setTel(c5.getStringCellValue());//tel

                Users.add(user);
            }
        }


        return Users;
    }




}
