package com.ysy.doublec.Service;

import com.ysy.doublec.Mapper.CellDao;
import com.ysy.doublec.Pojo.Cell;
import com.ysy.doublec.Pojo.CellPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class CellService {
    @Autowired
    CellDao cellDao;
    @Value("${file.upload-folder}")
    private String path;

    public String addCellPic(CellPic cellPic) throws IOException {
        File f = new File(path);
        // 如果path对应的路径不存在，创建该目录
        if (!f.exists()) {
            f.mkdir();
        }
        //System.out.println(f.getAbsolutePath());
        // 调用调用MultipartFile的getOriginalFilename()方法获取原始文件名
        // 然后调用StringUtils的getFilenameExtension获取扩展名
        String extName = StringUtils.getFilenameExtension(cellPic.getCover().getOriginalFilename());
        String targetName = UUID.randomUUID().toString() + "." + extName;
        // 调用MultipartFile的transferTo()方法完成文件复制
        cellPic.getCover().transferTo(new File(path + targetName));
        return targetName;
    }

    public String getCellCount() {
        return cellDao.getCellCount();
    }

    public String addCell(Cell cell) {
        if (cellDao.findByCellName(cell.getName()) != null) {
            return "fail";
        } else {
            cellDao.addCell(cell);
            return "success";
        }
    }

//    public ArrayList<Member> listMembers(String start) {
//        return memberDao.listMembers(start);
//    }
//
//    public Member getMember(String id) {
//        return memberDao.getMember(id);
//    }
//
//    public String editMember(Member member) {
//        memberDao.editMember(member);
//        return "success";
//    }
//
//    public void delMember(String[] deleteIds) {
//        memberDao.delMember(deleteIds);
//    }
//
//    public Member listMemberByTell(String tell) {
//        return memberDao.listMemberByTell(tell);
//    }
}
