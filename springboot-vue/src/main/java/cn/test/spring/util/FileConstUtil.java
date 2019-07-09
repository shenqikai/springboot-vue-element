package cn.test.spring.util;

import java.util.Arrays;
import java.util.List;

public class FileConstUtil {

    public static class ExcelMessage {
        /**
         * 文件不存在提示信息
         */
        public static final String FILE_EXISTS = "文件不存在";
        /**
         * 导入表格后缀格式
         */
        public static final List<String> EXTS = Arrays.asList("xls", "xlsx");
        /**
         * 文件类型不正确提示信息
         */
        public static final String FILE_EXT_ERROR = "请选择正确的文件";
        /**
         * 导入成功提示信息
         */
        public static final String SUCCESS_MESSAGE = "导入成功";
        /**
         * 导入失败提示信息
         */
        public static final String ERROR_MESSAGE = "导入失败";
    }
}