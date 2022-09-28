package com.ysy.doublec.Controller;

import com.alibaba.fastjson.JSON;
import com.ysy.doublec.Pojo.Member;
import com.ysy.doublec.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(String memberInfo) {
        if (memberInfo.equals("")) {
            return "非法操作！！";
        }
        Member member = JSON.parseObject(memberInfo, Member.class);
        return memberService.add(member);
    }
}
