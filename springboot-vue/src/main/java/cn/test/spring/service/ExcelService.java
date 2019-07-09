package cn.test.spring.service;

import cn.test.spring.dao.pojo.User;
import cn.test.spring.util.FileConstUtil;
import cn.test.spring.util.ImportExcelUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ExcelService {

    @Transactional
    public JSONObject importExcel(MultipartFile file)throws IOException {
        JSONObject object = new JSONObject();
        InputStream in = null;
        //定义listob存储表格结构
        List<List<Object>>listob = null;
        try {
            if (file.isEmpty()){
                object.put("msg", FileConstUtil.ExcelMessage.FILE_EXISTS);
            }else if (!FileConstUtil.ExcelMessage.EXTS.contains(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1))){
                // 判断文件类型是否正确
                object.put("msg", FileConstUtil.ExcelMessage.FILE_EXT_ERROR);
            }else {
                in = file.getInputStream();
                //获取表格数据
                listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
                for (int i = 0;i<listob.size();i++){
                    List<Object>lo = listob.get(i);
                    User user = new User();
                    user.setUsername(String.valueOf(lo.get(1)));
                    user.setPassword(String.valueOf(lo.get(2)));
                    user.setEmail(String.valueOf(lo.get(3)));
                    user.setAddress(String.valueOf(lo.get(4)));
                    user.setTel(String.valueOf(lo.get(5)));
                    System.out.println("打印信息--->id");

                }
                object.put("msg",FileConstUtil.ExcelMessage.SUCCESS_MESSAGE);
            }
        }catch (Exception e){
            e.printStackTrace();
            object.put("msg", FileConstUtil.ExcelMessage.ERROR_MESSAGE);
        }
        return  object;
    }

}
