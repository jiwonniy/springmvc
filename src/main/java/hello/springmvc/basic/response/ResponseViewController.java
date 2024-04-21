package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    // 3가지 방법이 존재한다!

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    //string 으로 반환
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");
        return "response/hello"; //view 의 논리적인 이름
    }

    //만약에 v2를 @ResponseBody를 붙이면 그냥 String 으로 반환됨.
    @ResponseBody
    @RequestMapping("/response-view-v21")
    public String responseViewV21(Model model) {
        model.addAttribute("data", "hello!!");
        return "response/hello"; //그냥 스트링으로 반환.. http 응답 메시지로 나가버림, view를 안찾음
    }

    //void 로 반환은 권장하지 않음
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }
}
