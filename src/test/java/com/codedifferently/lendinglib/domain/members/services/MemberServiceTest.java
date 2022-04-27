package com.codedifferently.lendinglib.domain.members.services;

import com.codedifferently.lendinglib.domain.members.exceptions.MemberNotFoundException;
import com.codedifferently.lendinglib.domain.members.models.Member;
import com.codedifferently.lendinglib.domain.members.models.services.MemberService;
import com.codedifferently.lendinglib.domain.members.repos.MemberRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import static org.mockito.BDDMockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MemberServiceTest {

    @MockBean
    private MemberRepo memberRepo;

    @Autowired
    private MemberService memberService;

    private Member testMemberIn;
    private Member testMemberOut;

    @BeforeEach
    public void setUp(){
        testMemberIn = new Member("Bob", "Dole", true);
        testMemberOut = new Member("Bob", "Dole", true);
        testMemberOut.setId(1l);

    }

    @Test
    @DisplayName("Create Member Test")
    public void createMemberTest(){
        doReturn(testMemberOut).when(memberRepo).save(testMemberIn);
        Member member = memberService.create(testMemberIn);
        Assertions.assertNotNull(member);
        Assertions.assertEquals(testMemberOut.toString(),member.toString());
    }

    @Test
    @DisplayName("Get by id test 1 - success")
    public void getByIdTest01() throws MemberNotFoundException {
        doReturn(Optional.of(testMemberOut)).when(memberRepo).findById(1l);
        Member actualMember = memberService.getById(1l);
        Assertions.assertEquals(testMemberOut.toString(), actualMember.toString());
    }

    @Test
    @DisplayName("Get by id test 2 - fail")
    public void getByIdTest02(){
        doReturn(Optional.empty()).when(memberRepo).findById(1l);
        Assertions.assertThrows(MemberNotFoundException.class, ()-> {
            memberService.getById(1l);
        });
    }

    @Test
    @DisplayName("Get by Full Name Test")
    public void getByFullNameTest() throws MemberNotFoundException {
        String firstName = "Bob";
        String lastName = "Dole";
        doReturn(Optional.of(testMemberOut)).when(memberRepo).findByFirstNameAndLastName(firstName, lastName);
        Member actualMember = memberService.getByFullName(firstName, lastName);
        Assertions.assertEquals(firstName, actualMember.getFirstName());
    }

}
