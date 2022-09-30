package com.ysy.doublec.Controller;

import com.alibaba.fastjson.JSON;
import com.ysy.doublec.Pojo.Member;
import com.ysy.doublec.Service.CellService;
import com.ysy.doublec.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/cell")
public class CellController {
    @Autowired
    CellService cellService;

//    @RequestMapping("/addMember")
//    @ResponseBody
//    public String addMember(String memberInfo) {
//        if (memberInfo.equals("")) {
//            return "非法操作！！";
//        }
//        Member member = JSON.parseObject(memberInfo, Member.class);
//        return memberService.addMember(member);
//    }

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
