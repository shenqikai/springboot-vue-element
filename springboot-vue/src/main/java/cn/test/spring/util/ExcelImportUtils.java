//package cn.test.spring.util;
//
//import org.apache.poi.hssf.usermodel.HSSFDataFormat;
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class ExcelImportUtils {
//    public static String[] SheetName;
//
//    // @描述：是否是2003的excel，返回true是2003
//    public static boolean isExcel2003(String filePath)  {
//        return filePath.matches("^.+\\.(?i)(xls)$");
//    }
//
//    //@描述：是否是2007的excel，返回true是2007
//    public static boolean isExcel2007(String filePath)  {
//        return filePath.matches("^.+\\.(?i)(xlsx)$");
//    }
//
//    /**
//     * 验证EXCEL文件
//     * @param filePath
//     * @return
//     */
//    public static boolean validateExcel(String filePath){
//        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))){
//            return false;
//        }
//        return true;
//    }
//    public  static List<String[]> getExcelData(MultipartFile file) throws IOException {
//        //获得Workbook工作薄对象
//        Workbook workbook = getWorkBook(file);
//        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
//        List<String[]> list = new ArrayList<String[]>();
//        Sheet sheet;
//        if(workbook != null){
//            SheetName=new String[workbook.getNumberOfSheets()];
//            //获得当前sheet工作表
//            for (int i = 0;i<workbook.getNumberOfSheets();i++){
//                sheet=workbook.getSheetAt(i);
//                SheetName[i]=sheet.getSheetName();
//                //获得当前sheet的开始行
//                int firstRowNum  = sheet.getFirstRowNum();
//                //获得当前sheet的结束行
//                int lastRowNum = sheet.getLastRowNum();
//                //循环除了第一行的所有行
//                for(int rowNum = firstRowNum+1;rowNum <=lastRowNum;rowNum++){
//                    //获得当前行
//                    Row row = sheet.getRow(rowNum);
//
//                    //获得总列数
//                    int totalCellNum =  sheet.getRow(0).getLastCellNum();
//                    if(row == null){
//                        continue;
//                    }
//                    //获得当前行的开始列
//                    int firstCellNum = row.getFirstCellNum();
//                    //2018.12.13
//                    if (firstCellNum == -1){
//                        continue;
//                    }
//                    //
//                    //获得当前行的列数
//                    int lastCellNum =  Math.max(row.getLastCellNum(), totalCellNum);
//                    String[] cells = new String[lastCellNum+1];
//                    //循环当前行
//                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
//                        Cell cell =row.getCell(cellNum, Row.RETURN_BLANK_AS_NULL);
//                        if(cell == null){
//                            cells[cellNum] = " ";
////                            if (cellNum==1 || cellNum==2 || cellNum==3 || cellNum==4 || cellNum==6
////                            ||cellNum==7 || cellNum==8 || cellNum ==10){
////                                return new ArrayList<>();
////                            }
//                        }else{
//                            if (cellNum == 7 || cellNum == 10)//金额，数量
//                            {
//                                if (cell.getCellType() != 0 ){//数值类型
//                                    list = new ArrayList<>();
//                                    return list;
//                                }
//                            }
//                            cells[cellNum] = getCellValue(cell);
//                        }
//                        cells[lastCellNum]=SheetName[i];
//                    }
//                    list.add(cells);
//                }
//            }
//        }
//        return list;
//    }
//
//    public  static List<String[]> getExcelDataNew(MultipartFile file) throws IOException {
//        //获得Workbook工作薄对象
//        Workbook workbook = getWorkBook(file);
//        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
//        List<String[]> list = new ArrayList<String[]>();
//        Sheet sheet;
//        if(workbook != null){
//            //获得当前sheet工作表
//            for (int i = 0;i<workbook.getNumberOfSheets();i++){
//                sheet=workbook.getSheetAt(i);
//                //获得当前sheet的开始行
//                int firstRowNum  = sheet.getFirstRowNum();
//                //获得当前sheet的结束行
//                int lastRowNum = sheet.getLastRowNum();
//                //循环除了第一行的所有行
//                for(int rowNum = firstRowNum+1;rowNum <=lastRowNum;rowNum++){
//                    //获得当前行
//                    Row row = sheet.getRow(rowNum);
//
//                    //获得总列数
//                    int totalCellNum =  sheet.getRow(0).getLastCellNum();
//                    if(row == null){
//                        continue;
//                    }
//                    //获得当前行的开始列
//                    int firstCellNum = row.getFirstCellNum();
//                    //2018.12.13
//                    if (firstCellNum == -1){
//                        continue;
//                    }
//                    //
//                    //获得当前行的列数
//                    int lastCellNum =  Math.max(row.getLastCellNum(), totalCellNum);
//                    String[] cells = new String[lastCellNum+1];
//                    //循环当前行
//                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
//                        Cell cell =row.getCell(cellNum, Row.RETURN_BLANK_AS_NULL);
//                        if(cell == null){
//                            cells[cellNum] = " ";
//                            if (cellNum==1 || cellNum==2 || cellNum==3 || cellNum==4 || cellNum==6
//                            ||cellNum==7 || cellNum==8 || cellNum ==10){
//                                return new ArrayList<>();
//                            }
//                        }else{
//                            if (cellNum == 7 || cellNum == 10)//金额，数量
//                            {
//                                if (cell.getCellType() != 0 ){//数值类型
//                                    list = new ArrayList<>();
//                                    return list;
//                                }
//                            }
//                            cells[cellNum] = getCellValue(cell);
//                        }
//                    }
//                    list.add(cells);
//                }
//            }
//        }
//        return list;
//    }
//
//    /**
//     * 检查文件
//     * @param file
//     * @throws IOException
//     */
//    public  static  int  checkFile(MultipartFile file) throws IOException {
//        int result = 0;
//        //获得文件名
//        String fileName = file.getOriginalFilename();
//        //判断文件是否是excel文件
//        if(!fileName.endsWith("xls") && !fileName.endsWith("xlsx")){
//            result = -1;
//        }
//        return result;
//    }
//    public   static Workbook getWorkBook(MultipartFile file) {
//        //获得文件名
//        String fileName = file.getOriginalFilename();
//        //创建Workbook工作薄对象，表示整个excel
//        Workbook workbook = null;
//        try {
//            //获取excel文件的io流
//            InputStream is = file.getInputStream();
//            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
//            if(fileName.endsWith("xls")){
//                //2003
//                workbook = new HSSFWorkbook(is);
//            }else if(fileName.endsWith("xlsx")){
//                //2007 及2007以上
//                workbook = new XSSFWorkbook(is);
//                System.out.println(workbook == null);
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return workbook;
//    }
//
//    public  static String getCellValue(Cell cell){
//        String cellValue = "";
//        if(cell == null){
//            return cellValue;
//        }
//        //判断数据的类型
//        switch (cell.getCellType()){
//            case Cell.CELL_TYPE_NUMERIC: //数字
//                cellValue = stringDateProcess(cell);
//                break;
//            case Cell.CELL_TYPE_STRING: //字符串
//                cellValue = String.valueOf(cell.getStringCellValue());
//                break;
//            case Cell.CELL_TYPE_BOOLEAN: //Boolean
//                cellValue = String.valueOf(cell.getBooleanCellValue());
//                break;
//            case Cell.CELL_TYPE_FORMULA: //公式
//                cellValue = String.valueOf(cell.getCellFormula());
//                break;
//            case Cell.CELL_TYPE_BLANK: //空值
//                cellValue = "";
//                break;
//            case Cell.CELL_TYPE_ERROR: //故障
//                cellValue = "非法字符";
//                break;
//            default:
//                cellValue = "未知类型";
//                break;
//        }
//        return cellValue;
//    }
//    /**
//     * 时间格式处理
//     * @return
//     * @author Liu Xin Nan
//     * @data 2017年11月27日
//     */
//    public  static String stringDateProcess(Cell cell){
//        String result = new String();
//        if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
//            SimpleDateFormat sdf = null;
//            if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
//                sdf = new SimpleDateFormat("HH:mm");
//            } else {// 日期
//                sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//            }
//            Date date = cell.getDateCellValue();
//            result = sdf.format(date);
//        } else if (cell.getCellStyle().getDataFormat() == 58) {
//            // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//            double value = cell.getNumericCellValue();
//            Date date = org.apache.poi.ss.usermodel.DateUtil
//                    .getJavaDate(value);
//            result = sdf.format(date);
//        } else {
//            double value = cell.getNumericCellValue();
//            int index = cell.getColumnIndex();
//            CellStyle style = cell.getCellStyle();
//            DecimalFormat format = new DecimalFormat();
//            String temp = style.getDataFormatString();
//            if (index != 7){//不是金额
//                // 单元格设置成常规
//                if (temp.equals("General")) {
//                    format.applyPattern("#");
//                }
//            }
//            result = format.format(value);
//        }
//
//        return result;
//    }
//}
