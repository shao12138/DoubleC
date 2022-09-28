package com.ysy.doublec.Service;

import com.ysy.doublec.Mapper.MemberDao;
import com.ysy.doublec.Pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    public String add(Member member) {
        if (memberDao.findByMemberTell(member.getTell()) != null) {
            return "fail";
        } else {
            memberDao.add(member);
            return "success";
        }
    }
}
