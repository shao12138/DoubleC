package com.ysy.doublec.Service;

import com.ysy.doublec.Mapper.MemberDao;
import com.ysy.doublec.Pojo.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    public String addMember(Member member) {
        if (memberDao.findByMemberTell(member.getTell()) != null) {
            return "fail";
        } else {
            memberDao.addMember(member);
            return "success";
        }
    }

    public String getMemberCount() {
        return memberDao.getMemberCount();
    }

    public ArrayList<Member> listMembers(String start) {
        return memberDao.listMembers(start);
    }

    public Member getMember(String id) {
        return memberDao.getMember(id);
    }

    public String editMember(Member member) {
        memberDao.editMember(member);
        return "success";
    }
}
