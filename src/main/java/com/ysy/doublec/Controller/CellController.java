package com.ysy.doublec.Controller;

import com.alibaba.fastjson.JSON;
import com.ysy.doublec.Pojo.Cell;
import com.ysy.doublec.Pojo.CellPic;
import com.ysy.doublec.Pojo.Member;
import com.ysy.doublec.Service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cell")
public class CellController {
    @Autowired
    CellService cellService;

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

    @RequestMapping("/listCells")
    @ResponseBody
    public ArrayList<Cell> listCells(String start) {
        return cellService.listCells(start, "1");
    }
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
