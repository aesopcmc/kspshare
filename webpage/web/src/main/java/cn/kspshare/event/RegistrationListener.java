package cn.kspshare.event;

import cn.kspshare.constant.KspConstants;
import cn.kspshare.domain.Member;
import cn.kspshare.mail.EmailService;
import cn.kspshare.service.KspUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    @Autowired
    private KspUserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private KspConstants kspConstants;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        Member user = event.getUser();
        String token = UUID.randomUUID().toString();
        this.userService.createVerificationToken(user, token);

        String recipientAddress = user.getEmail();
        String subject = "坎巴拉论坛注册用户激活";
        String confirmationUrl = event.getAppUrl() + "/registrationConfirm?token=" + token;

        String content = "<html>" +
                "<body>" +
                "   <h3>邮件验证</h3>" +
                "   <p style='color:blue'>点击确认激活完成注册</p>" +
                "   <a href='"+kspConstants.siteHost+confirmationUrl+"' style='color:'>确认激活</a>" +
                "</body>" +
                "</html>";
        System.out.println("开始发送");
        emailService.sendHtmlEmail(recipientAddress, subject, content);
        System.out.println("发送成功");
    }
}