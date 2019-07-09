package cn.test.spring.util;

import cn.test.spring.dao.mapper.UserMapper;
import cn.test.spring.dao.pojo.Result;
import cn.test.spring.dao.pojo.StatusCode;
import cn.test.spring.dao.pojo.User;
import cn.test.spring.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class PoiUtils {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    /**
     * 根据集合返回一个http响应体
     * @param allUsers 职称等级列表
     * @return http响应实体
     */
    public static ResponseEntity<byte[]> exportUserExcel(List<User> allUsers) throws IOException {
        // 创建一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 设置文档属性
        workbook.createInformationProperties();
        // 获取文档的文档摘要信息
        DocumentSummaryInformation sumInfo = workbook.getDocumentSummaryInformation();
        // 设置摘要信息
        sumInfo.setCompany("towards");
        sumInfo.setManager("chet");
        sumInfo.setCategory("user information");
        // 创建一个新的单元格样式并将其添加到工作簿的样式表中。
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        // 获取与给定格式字符串匹配的格式索引，自动将“文本”转换为excel的格式字符串来表示文本
        short format = HSSFDataFormat.getBuiltinFormat("m/d/yy");
        // 设置表格中的日期格式,设置数据格式(必须是有效格式)
        cellStyle.setDataFormat(format);

        // 为这个HSSFWorkbook创建一个HSSFSheet，将它添加到工作表中
        HSSFSheet sheet = workbook.createSheet("用户信息表");

        // 设置表格列名
        // 在工作表中创建一个新行
        HSSFRow row = sheet.createRow(0);
        // 在行中创建新的单元格,参数为列号
        HSSFCell cell0 = row.createCell(0);
        HSSFCell cell1 = row.createCell(1);
        HSSFCell cell2 = row.createCell(2);
        HSSFCell cell3 = row.createCell(3);
        HSSFCell cell4 = row.createCell(4);
        HSSFCell cell5 = row.createCell(5);

        // 为单元格设置一个字符串值
        cell0.setCellValue("编号");
        cell1.setCellValue("姓名");
        cell2.setCellValue("密码");
        cell3.setCellValue("email");
        cell4.setCellValue("tel");
        cell5.setCellValue("address");


        // 循环设置表格中的数据
        for (int i = 0; i < allUsers.size(); i++) {
            // 返回列表中指定位置的元素
            User level = allUsers.get(i);
            HSSFRow r = sheet.createRow(i + 1);
            HSSFCell c0 = r.createCell(0);
            HSSFCell c1 = r.createCell(1);
            HSSFCell c2 = r.createCell(2);
            HSSFCell c3 = r.createCell(3);
            HSSFCell c4 = r.createCell(4);
            HSSFCell c5 = r.createCell(5);

            c0.setCellValue(level.getId());
            c1.setCellValue(level.getUsername());
            c2.setCellValue(level.getPassword());
            // 设置日期格式
//            c3.setCellStyle(cellStyle);
//            c3.setCellValue(level.getCreatedate());
            c3.setCellValue(level.getEmail());
            c4.setCellValue(level.getTel());
            c5.setCellValue(level.getAddress());
        }
        // 创建一个http请求头
        HttpHeaders headers = new HttpHeaders();
        // 设置，参数：1.控制方式-内嵌，2.文件名，在浏览器需转换格式
        headers.setContentDispositionFormData("attachment",
                new String("用户信息.xls".getBytes("UTF-8"), "iso-8859-1"));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 创建一个字节数组输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        // 使用给定的主体、头和状态代码创建一个新的http实体
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.CREATED);
        return responseEntity;
    }

    /**
     * 导入文件
     * @param file
     * @return
     * @throws IOException
     */



//
//    public  List<User> parseFileList(MultipartFile file) throws IOException {
//
//        List<User> Users = new ArrayList<>();
//        HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
//        HSSFSheet sheet = workbook.getSheetAt(0);
////        for (Row row : sheet) {
////            int index = 0;
////            for (Cell cell : row) {
////                //读取数据前设置单元格类型
////                cell.setCellType(CellType.STRING);
////                String value = cell.getStringCellValue();
////                System.out.print("value:" + value + " ");
////                index++;
////            }
////            System.out.println();
//////        }
//
//        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
//        for (int i = 1; i < physicalNumberOfRows; i++) {
//
//            HSSFRow row = sheet.getRow(i);
//            HSSFCell c0 = row.getCell(0);
//            HSSFCell c1 = row.getCell(1);
//            HSSFCell c2 = row.getCell(2);
//            HSSFCell c3 = row.getCell(3);
//            HSSFCell c4 = row.getCell(4);
//            HSSFCell c5 = row.getCell(5);
//            c5.setCellType(CellType.STRING);//因为号码是int类型，转换String类型时会出错，所以先给表格属性先设置好
//
//            //拿到所有数据
//            List<User>userList=userMapper.getAll();
//            for (User User: userList ){
//                if (c5.getStringCellValue()!=User.getTel()){
//
//                }
//            }
//            c5.setCellType(CellType.STRING);//因为号码是int类型，转换String类型时会出错，所以先给表格属性先设置好
//            double numericCellValue = c0.getNumericCellValue();
//            User user = new User();
//            user.setId((int)numericCellValue);
//            user.setUsername(c1.getStringCellValue()); //姓名
//            user.setPassword(c2.getStringCellValue());//密码
//            user.setEmail(c3.getStringCellValue());//email
//            user.setAddress(c4.getStringCellValue());//address
//            user.setTel(c5.getStringCellValue());//tel
//
//
//            Users.add(user);
//        }
//
//
//        return Users;
//    }
//
//




    public static String getCellValue(Cell cell) {
        String cellValue = "";
        // 以下是判断数据的类型
        switch (cell.getCellType()) {
            case NUMERIC: // 数字
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
                } else {
                    DataFormatter dataFormatter = new DataFormatter();
                    cellValue = dataFormatter.formatCellValue(cell);
                }
                break;
            case STRING: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN: // Boolean
                cellValue = cell.getBooleanCellValue() + "";
                break;
            case FORMULA: // 公式
                cellValue = cell.getCellFormula() + "";
                break;
            case BLANK: // 空值
                cellValue = "";
                break;
            case ERROR: // 故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

}
