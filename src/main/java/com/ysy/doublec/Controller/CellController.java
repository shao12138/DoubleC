package com.ysy.doublec.Controller;

import com.alibaba.fastjson.JSON;
import com.ysy.doublec.Pojo.Cell;
import com.ysy.doublec.Pojo.CellPic;
import com.ysy.doublec.Pojo.Member;
import com.ysy.doublec.Service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.validation.annotation.Validated;

import javax.servlet.ServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/cell")
public class CellController {
    @Autowired
    CellService cellService;
    @Value("${file.upload-folder}")
    private String path;

    @RequestMapping("/addCellPic")
    @ResponseBody
    public Map<String, Object> addCellPic(@Validated CellPic cellPic) throws IOException {
        String targetName = cellService.addCellPic(cellPic);
        HashMap result = new HashMap();
        result.put("targetName", targetName);
        result.put("src", "/uploads/" + targetName);
        return result;
    }

    @RequestMapping("/addCell")
    @ResponseBody
    public String addCell(String memberInfo) {
        Cell cell = JSON.parseObject(memberInfo, Cell.class);
        return cellService.addCell(cell);
    }

    @RequestMapping("/getCellCount")
    @ResponseBody
    public String getCellCount() {
        return cellService.getCellCount();
    }

    //    @RequestMapping("/listMember")
//    @ResponseBody
//    public Member listMember(String id) {
//        return memberService.getMember(id);
//    }
//    @RequestMapping("/listMemberByTell")
//    @ResponseBody
//    public Member listMemberByTell(String tell) {
//        return memberService.listMemberByTell(tell);
//    }
//
//    @RequestMapping("/listCells")
//    @ResponseBody
//    public ArrayList<Member> listMembers(String start) {
//        return memberService.listMembers(start);
//    }

//    @RequestMapping("/getMember")
//    @ResponseBody
//    public Member getMember(String id) {
//        Member member = memberService.getMember(id);
//        return member;
//    }
//
//    @RequestMapping("/editMember")
//    @ResponseBody
//    public String editMember(String memberInfo) {
//        if (memberInfo.equals("")) {
//            return "非法操作！！";
//        }
//        Member member = JSON.parseObject(memberInfo, Member.class);
//        return memberService.editMember(member);
//    }
//
//    @RequestMapping("/delMembers")
//    @ResponseBody
//    public void delMembers(String ids) {
//        String[] deleteIds = ids.split(",");
//        memberService.delMember(deleteIds);
//    }
}
