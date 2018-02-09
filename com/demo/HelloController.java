package com.demo;

import com.dao.TicketDao;
import com.entity.StageInfo;
import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.jfinal.log.Log4jLogFactory;
import com.jfinal.upload.UploadFile;
import com.service.TicketService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.util.ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class HelloController extends Controller {
    private Log4jLogFactory log4jLogFactory = new Log4jLogFactory();

    public void index() {
//        renderText("Hello JFinal World");
        Log log = log4jLogFactory.getLog(HelloController.class);
        log.debug("12313213");
        UploadFile file =getFile("file");//获取文件
//        try {
//            System.out.println(file.getContentType());
//            System.out.println(file.getFileName());
//            System.out.println(file.getOriginalFileName());
//            System.out.println(file.getParameterName());
//            System.out.println(file.getUploadPath());
//            String filename = file.getFileName();
//            String filetype1 = filename.substring(filename.length() - 3, filename.length());
//            String filetype2 = filename.substring(filename.length() - 4, filename.length());
//            File filedele = new File(file.getUploadPath() + "\\" + file.getFileName());

//            if (!filetype1.equals("xls") && !filetype2.equals("xlsx")) {
//                filedele.delete();
//                setAttr("success", false);
//                setAttr("info", "请传入excel。");
//                renderJson();
//                return;
//            }
//        }catch (Exception e ){
//            setAttr("success", false);
//            setAttr("info", "上传文件失败，请确认是否为.xls,.xlsx格式。");
//            renderJson();
//            return;
//        }
        TicketService ts = new TicketService();
//        File filedele2 = new File(file.getUploadPath() + "\\" + file.getFileName());
        //1.判断是否传入文件。之后需要研究传入的格式，和确认研究。
        File file1 = null;
        try {
            try {
                file1 = file.getFile();

            } catch (Exception e) {

                e.printStackTrace();
                setAttr("success2", true);
                setAttr("success", false);
                setAttr("info", "请确认是否传入文件。");
                setAttr("exInfo",e.getMessage());
                renderJson();
                return;
            }
            FileInputStream fis = null;
            ArrayList<StageInfo> siList = new ArrayList<>();
            Boolean flage = null;
            try {
                ReadExcel re = new ReadExcel();
                siList = re.toReadExcel(fis, file1);
//                filedele2.delete();
                flage = ts.saveTicketList(siList);
            } catch (Exception e) {
                e.printStackTrace();
                String exceppMessage = e.getMessage();
                setAttr("success", flage);
                setAttr("info", exceppMessage);
                renderJson();
                return;
            }
        } finally {

        }

    }
}
