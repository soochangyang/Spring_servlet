package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    //@RequestMapping(value = "/new-form" , method = RequestMethod.GET)
    public String newForm() {
        System.out.println("SpringMemberFormControllerV1.process");
        return "new-form";
    }

    @PostMapping("/save")
    //@RequestMapping(value = "/save",  method = RequestMethod.POST)
    public String save(@RequestParam("userName") String userName ,
                             @RequestParam("age") int age,
                             Model model) {

        Member member = new Member(userName, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        model.addAttribute("member", member);

        return "save-result";
    }

    @GetMapping
    //@RequestMapping(method = RequestMethod.GET)
    public String members(Model model){
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);

        return "member-list";
    }
}
